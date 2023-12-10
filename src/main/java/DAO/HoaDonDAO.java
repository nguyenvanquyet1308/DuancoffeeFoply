/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
import ThuVien.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyenvanquyet
 */
public class HoaDonDAO extends CoffeeDao<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon (MaHD,MaKH,MaNV,NgayDonHang,MaBan,ThanhTien,TrangThai) VALUES (?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE HoaDon SET MaKH = ?,MaNV =?,NgayDonHang=?,MaBan=?,ThanhTien=? where MaHD=?";
    String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD=?";
    String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
    String SELECT_BY_ID_SQL = "SELECT * FROM HoaDon WHERE MaHD=?";
    String UPDATE_THANHTIEN = "update HoaDon set ThanhTien = ? , trangthai = 1 where MaHD =?";
    String SELECT_HOADON_YEAR = "select * from hoadon where year(NgayDonHang) = ? and TrangThai = 1 ";
    String SELECT_HOADON_YEAR1 = "select * from hoadon where NgayDonHang = ? ";
    String SELECT_HOADON_BAN = "select * from hoadon where maban = ?";
    String SELECT_HOADON_TRANGTHAI = "select * from hoadon where trangthai = 0";
    String SELECT_INHOADON = "select hoadon.mahd,manv,ngaydonhang,tensp,giatien,soluong,thanhtien from hoadon inner join ChiTietHoaDon on ChiTietHoaDon.MaHD = HoaDon.MaHD inner join SanPham on SanPham.MaSP = ChiTietHoaDon.MaSP where hoadon.mahd = ?";
    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaKH(),
                entity.getMaNV(),
                entity.getNgayDatHang(),
                entity.getMaBan(),
                entity.getThanhTien(),
                entity.getTrangThai()
        );
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getMaKH(),
                entity.getMaNV(),
                entity.getNgayDatHang(),
                entity.getMaBan(),
                entity.getThanhTien(),
                entity.getMaHD()
        );
    }

    @Override
    public void delete(String maHD) {
        JdbcHelper.executeUpdate(DELETE_SQL, maHD);
    }

    @Override
    public HoaDon selectById(String maHD) {
        List<HoaDon> list = this.selectBySQL(SELECT_BY_ID_SQL, maHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<HoaDon> selectBySQL(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaKH(rs.getString("MaKH"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDatHang(rs.getDate("NgayDonHang"));
                entity.setMaBan(rs.getString("MaBan"));
                entity.setThanhTien(rs.getFloat("ThanhTien"));
                entity.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 

//    public List<HoaDon> updateDuaVaohoadon(String mahd, int thanhtien) {
//        List<HoaDon> list = new ArrayList<>();
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=DuanCoffee";
//            Connection con = DriverManager.getConnection(url, "sa", "123456");
//            String sql = "update HoaDon set ThanhTien = ? where MaHD =?";
//            PreparedStatement pstt = con.prepareStatement(sql);
//            pstt.setString(1, mahd);
//            pstt.setInt(2, thanhtien);
//            pstt.executeUpdate();
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }
    public List<HoaDon> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM HoaDon WHERE MaHD LIKE ?";
        return this.selectBySQL(SQL, "%" + keyword + "%");
    }

    public List<HoaDon> selecthoadonBan() {
        String SQL = SELECT_HOADON_TRANGTHAI;
        return this.selectBySQL(SQL);
    }

//    public List<HoaDon> UpdateThanhTienhoadon(String mahd,float thanhtien) {
//        String SQL = UPDATE_THANHTIEN;
//        return this.selectBySQL(SQL,mahd,thanhtien);
//    }

    public List<HoaDon> selectThongkeHoaDon(int date) {
        String SQL = SELECT_HOADON_YEAR;
        return this.selectBySQL(SQL, date);
    }

    public List<HoaDon> selectThongkeHoaDonjdate(LocalDate date) {
        String SQL = SELECT_HOADON_YEAR1;
        return this.selectBySQL(SQL, date);
    }
     public List<HoaDon> selectInhoadon(String mahd) {
        String SQL = SELECT_INHOADON;
        return this.selectBySQL(SQL, mahd);
    }
       public List<HoaDon> selectThongkeChart(int Namdonhang) {
        String SQL = "select MONTH(ngaydonhang) as 'Thang',sum(thanhtien) as 'DoanhThu' from hoadon where YEAR(ngaydonhang) = ? group by MONTH(ngaydonhang)";
        return this.selectBySQL(SQL, Namdonhang);
    }
    
    

    public int getDoanhThu(int nam) {
        int doanhthu = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec Doanhthunam ?";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    doanhthu = (int) rs.getFloat("DoanhThuNam");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doanhthu;
    }

    public int getTonghoadonNam(int nam) {
        int tonghoadonnam = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec TonghoadonNam ?";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    tonghoadonnam = (int) rs.getInt("TonghoadonNam");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tonghoadonnam;
    }

    public int getkhachHangTheoNam(int nam) {
        int tongkhachhangtheoNam = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec tongkhachhangtheoNam ?";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    tongkhachhangtheoNam = (int) rs.getInt("Tongkhachhang");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tongkhachhangtheoNam;
    }

    public int getdoanhThu(int ngay, int thang, int nam) {
        int tongdoanhthu = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec TinhNgayThangNam ? ,?, ?";
                rs = JdbcHelper.executeQuery(sql, ngay, thang, nam);
                while (rs.next()) {
                    tongdoanhthu = (int) rs.getInt("tongdoanhthu");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tongdoanhthu;
    }

    public int getkhachhang(int ngay, int thang, int nam) {
        int tongkhachang = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec TinhNgayThangNam ? ,?, ?";
                rs = JdbcHelper.executeQuery(sql, ngay, thang, nam);
                while (rs.next()) {
                    tongkhachang = (int) rs.getInt("tongkhachang");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tongkhachang;
    }

    public int gethoadon(int ngay, int thang, int nam) {
        int tonghoadon = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "exec TinhNgayThangNam ? ,?, ?";
                rs = JdbcHelper.executeQuery(sql, ngay, thang, nam);
                while (rs.next()) {
                    tonghoadon = (int) rs.getInt("tonghoadon");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tonghoadon;
    }
}
