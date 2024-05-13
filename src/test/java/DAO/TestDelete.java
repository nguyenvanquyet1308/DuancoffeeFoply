package DAO;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Entity.NhanVien;

public class TestDelete {
	NhanVienDAO dao = new NhanVienDAO();

    @Test
    public void testDeleteEmployee() throws Exception {//test delete nhanvien
        String Manv = "test2";
        
        int coutTruocDelete = dao.countEmployees();
        dao.delete(Manv);
        int coutSauDelete = dao.countEmployees();
        
        assertEquals(coutSauDelete, coutTruocDelete - 1);
    }
    @Test
    public void testDeleteEmployee1() throws Exception {//test delete nhanvien
        String Manv = "";
        
        int coutTruocDelete = dao.countEmployees();
        dao.delete(Manv);
        int coutSauDelete = dao.countEmployees();
        
        assertEquals(coutSauDelete, coutTruocDelete - 1);
    }
    @Test
    public void testDeleteProduct() throws Exception {//test delete product
        String MaSP = "SP001";
        
        int coutTruocDelete = dao.countEmployees();
        dao.delete(MaSP);
        int coutSauDelete = dao.countEmployees();
        
        assertEquals(coutSauDelete, coutTruocDelete - 1);
    }

    


  
}
