/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhanVien;
import ThuVien.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenvanquyet
 */
public class NhanVienDAO extends CoffeeDao<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NhanVien (MaNV,MatKhau,TenNV,SDT,DiaChi,ChucVu,GioiTinh,HinhAnh) VALUES (?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET MatKhau = ?,TenNV =?,SDT=?,DiaChi=? ,ChucVu=?,GioiTinh=?,HinhAnh=? where MaNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getTenNV(),
                entity.getSDT(),
                entity.getDiaChi(),
                entity.getChucVu(),
                entity.getGioiTinh(),
                entity.getHinhanh()
        );
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMatKhau(),
                entity.getTenNV(),
                entity.getSDT(),
                entity.getDiaChi(),
                entity.getGioiTinh(),
                entity.getChucVu(),
                entity.getHinhanh(),
                entity.getMaNV()
        );
    }

    @Override
    public void delete(String MaNV) {
        JdbcHelper.executeUpdate(DELETE_SQL, MaNV);
    }

    @Override
    public NhanVien selectById(String MaNV) {
        List<NhanVien> list = this.selectBySQL(SELECT_BY_ID_SQL, MaNV);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySQL(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiaChi(rs.getString("DiaChi"));
                entity.setChucVu(rs.getBoolean("ChucVu"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setHinhanh(rs.getBytes("HinhAnh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }
}
