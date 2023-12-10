package JavaSwingThuVien;

import DAO.*;
import Entity.NhanVien;
import Entity.SanPham;
import ThuVien.JdbcHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
public class MyQuery {

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Duancoffee", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<Product2> BindTable() {
        ArrayList<Product2> list = new ArrayList<Product2>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM SanPham");

            Product2 p;
            while (rs.next()) {
                p = new Product2(
                        rs.getString("MaSP"),
                        rs.getString("TenSP"),
                        rs.getFloat("Gia"),
                        rs.getString("MaLoai"),
                        rs.getString("Mota"),
                        rs.getBytes("HinhAnh")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    protected ArrayList<Product2> selectBySQL(String sql, Object... args) {
        ArrayList<Product2> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Product2 entity = new Product2();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setGia(rs.getFloat("Gia"));
                entity.setMaLoai(rs.getString("MaLoai"));
                entity.setMoTa(rs.getString("MoTa"));
                entity.setHinhanh(rs.getBytes("HinhAnh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Product2> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM SanPham WHERE TenSP LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }

    public List<Product2> selectTheoTenLoai(String keyword) {
        String SQL = "select Masp,tensp,gia,sanpham.maloai,mota,hinhanh from sanpham inner join loai on loai.MaLoai = SanPham.MaLoai where TenLoai like ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }

    protected ArrayList<NhanVien> selectBySQLStaff(String sql, Object... args) {
        ArrayList<NhanVien> list = new ArrayList<>();
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

    public ArrayList<NhanVien> selectByKeywordSaff(String keyword) {
        String SQL = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        return this.selectBySQLStaff(SQL, "%" + keyword + "%");
    }

}
