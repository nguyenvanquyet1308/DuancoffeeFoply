/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.ChiTietHoaDon;
import Entity.SanPham;
import ThuVien.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenvanquyet
 */
public class ChiTietHoaDonDAO extends CoffeeDao<ChiTietHoaDon, Integer> {

    String INSERT_SQL = "INSERT INTO ChiTietHoaDon (MaHD,MaSP,SoLuong,GiaTien) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE ChiTietHoaDon SET MaHD = ?,MaSP =?,SoLuong=?,GiaTien =? where ChiTietHoaDon=?";
    String DELETE_SQL = "DELETE FROM ChiTietHoaDon WHERE MaHDCT=?";
    String SELECT_ALL_SQL = "SELECT * FROM ChiTietHoaDon";
    String SELETE_INNER_IOIN = "select mahdct,mahd,sanpham.MaSP,TenSp,soluong,giatien * soluong as GiaTien from ChiTietHoaDon inner join SanPham on ChiTietHoaDon.MaSP = SanPham.MaSP WHERE MaHD = ?";
    String SELECT_BY_ID_SQL = "SELECT * FROM ChiTietHoaDon WHERE ChiTietHoaDon=?";
    String UPDATE_SOLUONG = "UPDATE CHITIETHOADON SET SOLUONG = ? WHERE MASP = ?";

    @Override
    public void insert(ChiTietHoaDon entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaSP(),
                entity.getSoLuong(),
                entity.getGiaTien()
        );
    }

    @Override
    public void update(ChiTietHoaDon entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMaHD(),
                entity.getMaSP(),
                entity.getSoLuong(),
                entity.getGiaTien(),
                entity.getHoaDonCT()
        );
    }

    @Override
    public void delete(Integer maHDCT) {
        JdbcHelper.executeUpdate(DELETE_SQL, maHDCT);
    }

    @Override
    public ChiTietHoaDon selectById(Integer maHDCT) {
        List<ChiTietHoaDon> list = this.selectBySQL(SELECT_BY_ID_SQL, maHDCT);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        return this.selectBySQL(SELETE_INNER_IOIN);
    }

    @Override
    protected List<ChiTietHoaDon> selectBySQL(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChiTietHoaDon entity = new ChiTietHoaDon();
                entity.setHoaDonCT(rs.getInt("MaHDCT"));
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setGiaTien(rs.getFloat("GiaTien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public List<ChiTietHoaDon> selectMaHD(String maHD) {
        String SQL = SELETE_INNER_IOIN;
        return selectBySQL(SQL, maHD);
    }

    public void updateSoluong(int soluong, String masp) {
        JdbcHelper.executeUpdate(UPDATE_SOLUONG, soluong, masp);
    }

    public List<ChiTietHoaDon> selectSoLuong(String masp) {
        String SQL = "select Soluong from chitiethoadon where masp = ?";
        return selectBySQL(SQL, masp);
    }

    public List<ChiTietHoaDon> selectMaHD1(String mahd) {
        String SQL = SELETE_INNER_IOIN;
        return selectBySQL(SQL, mahd);
    }

}
