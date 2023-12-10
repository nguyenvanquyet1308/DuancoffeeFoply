/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Ban;
import ThuVien.JdbcHelper;
import java.util.List;
import Entity.Loai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiDAO extends CoffeeDao<Loai, String> {

    String INSERT_SQL = "INSERT INTO Loai (MaLoai,TenLoai) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE Loai SET TenLoai = ? where MaLoai=?";
    String DELETE_SQL = "DELETE FROM Loai WHERE MaLoai=?";
    String SELECT_ALL_SQL = "SELECT * FROM Loai";
    String SELECT_BY_ID_SQL = "SELECT * FROM Loai WHERE MaLoai=?";

    @Override
    public void insert(Loai entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaLoai(),
                entity.getTenLoai()
        );
    }

    @Override
    public void update(Loai entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL,
                entity.getTenLoai(),
                entity.getMaLoai()
        );
    }

    @Override
    public void delete(String maLoai) {
        JdbcHelper.executeUpdate(DELETE_SQL, maLoai);
    }

    @Override
    public Loai selectById(String maLoai) {
        List<Loai> list = this.selectBySQL(SELECT_BY_ID_SQL, maLoai);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Loai> selectAll() {
               return this.selectBySQL(SELECT_ALL_SQL);

    }
 

    @Override
    protected List<Loai> selectBySQL(String sql, Object... args) {
         List<Loai> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Loai entity = new Loai();
                entity.setMaLoai(rs.getString("MaLoai"));
                entity.setTenLoai(rs.getString("TenLoai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
