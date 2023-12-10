/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import ThuVien.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entity.KhachHang;
import Entity.SanPham;

/**
 *
 * @author nguyenvanquyet
 */
public class KhachHangDAO extends CoffeeDao<KhachHang, String> {

    String INSERT_SQL = "INSERT INTO KhachHang (MaKH,TenKH,SDT,MaBan) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang SET TenKH = ?,SDT =?,MaBan=? where MaKH=?";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH=?";
    String SELECT_ALL_SQL = "SELECT * FROM KhachHang";
    String SELECT_BY_ID_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";

    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaKH(),
                entity.getTenKH(),
                entity.getSDT(),
                entity.getMaban()
        );
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getTenKH(),
                entity.getSDT(),
                entity.getMaban(),
                entity.getMaKH()
        );
    }

    @Override
    public void delete(String MaKH) {
        JdbcHelper.executeUpdate(DELETE_SQL, MaKH);
    }

    @Override
    public KhachHang selectById(String MaKH) {
        List<KhachHang> list = this.selectBySQL(SELECT_BY_ID_SQL, MaKH);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MaKH"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setMaban(rs.getString("MaBan"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM Khachhang WHERE TenKH LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }

}
