package DAO;

import Entity.Loai;
import Entity.SanPham;
import ThuVien.JdbcHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.JTable;

/**
 * @author nguyenvanquyet
 */
public class SanPhamDAO extends CoffeeDao<SanPham, String> {

    String INSERT_SQL = "INSERT INTO SanPham (MaSP,TenSP,Gia,MaLoai,MoTa,HinhAnh) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SanPham SET TenSP = ?,Gia =?,MaLoai=?,MoTa=?,HinhAnh=? where MaSP=?";
    String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP=?";
    String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSP=?";
    String SELECT_BY_ID_SQL1 = "select MaSP,TenSP,Gia,MaLoai,MoTa,HinhAnh from SanPham";
    String SELECT_SEACH = "SELECT * FROM SanPham WHERE TenSP LIKE ?";

    @Override
    public void insert(SanPham entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getGia(),
                entity.getMaLoai(),
                entity.getMoTa(),
                entity.getHinhanh()
        );
    }

    @Override
    public void update(SanPham entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getTenSP(),
                entity.getGia(),
                entity.getMaLoai(),
                entity.getMoTa(),
                entity.getHinhanh(),
                entity.getMaSP()
        );
    }

    @Override
    public void delete(String String) {
        JdbcHelper.executeUpdate(DELETE_SQL, String);
    }

    @Override
    public SanPham selectById(String masp) {
        List<SanPham> list = this.selectBySQL(SELECT_BY_ID_SQL, masp);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
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

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=Duancoffee1", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public ArrayList<SanPham> BindTable() {
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM SanPham");
            SanPham p;
            while (rs.next()) {
                p = new SanPham(
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
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SanPham> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM SanPham WHERE TenSP LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }
     

}
