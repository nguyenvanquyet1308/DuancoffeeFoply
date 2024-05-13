package DAO;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import Entity.NhanVien;
import Entity.SanPham;

public class TestInsert {

	NhanVienDAO dao = new NhanVienDAO();
	SanPhamDAO daosp = new SanPhamDAO();

	@Test
	public void testInsertEmployee() throws Exception {// test insert nhanvien
		NhanVien newEmployee = new NhanVien();
		newEmployee.setMaNV("NV000");
		newEmployee.setMatKhau("vanquyet");
		newEmployee.setTenNV("Nguyeenx Van Quyet");
		newEmployee.setSDT("043920323");
		newEmployee.setDiaChi("Myx dduwc quang binh");
		newEmployee.setChucVu(true);
		newEmployee.setGioiTinh(true);

		byte[] imageData = Files.readAllBytes(
				Paths.get("D:\\BackUp\\Ky4\\MonDuAn1\\DuancoffeeFoply\\src\\main\\java\\ImageProduct\\7up.png"));
		newEmployee.setHinhanh(imageData);

		int coutTruocInsert = dao.countEmployees();
		dao.insert(newEmployee);
		int coutSauInsert = dao.countEmployees();
		Assert.assertEquals(coutSauInsert, coutTruocInsert + 1);
	}

	@Test
	public void CheckLoginTestInsertTrongMaNv() throws IOException {// test insert nhanvien
		boolean expected = false;
		boolean result = insertEmployee();
		// int coutSauInsert = dao.countEmployees();
		Assert.assertEquals(result, expected);
	}

	public boolean insertEmployee() {
		try {
			NhanVien newEmployee = new NhanVien();
			newEmployee.setMaNV("");
			newEmployee.setMatKhau("vanquyet");
			newEmployee.setTenNV("Nguyeenx Van Quyet");
			newEmployee.setSDT("043920323");
			newEmployee.setDiaChi("Myx dduwc quang binh");
			newEmployee.setChucVu(true);
			newEmployee.setGioiTinh(true);
			byte[] imageData = Files.readAllBytes(
					Paths.get("D:\\BackUp\\Ky4\\MonDuAn1\\DuancoffeeFoply\\src\\main\\java\\ImageProduct\\7up.png"));
			newEmployee.setHinhanh(imageData);
			dao.insert(newEmployee);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Test
	public void testInsertProduct() throws Exception {// test insert nhanvien
		SanPham sp = new SanPham();

		sp.setMaSP("sp100");
		sp.setTenSP("Nước ngọt");
		sp.setGia(100);
		sp.setMaLoai("L010");
		sp.setMoTa("NƯỚC ngonn");

		byte[] imageData = Files.readAllBytes(
				Paths.get("D:\\BackUp\\Ky4\\MonDuAn1\\DuancoffeeFoply\\src\\main\\java\\ImageProduct\\7up.png"));
		sp.setHinhanh(imageData);

		int coutTruocInsert = daosp.countSanPham();
		daosp.insert(sp);
		int coutSauInsert = daosp.countSanPham();
		Assert.assertEquals(coutSauInsert, coutTruocInsert + 1);
	}
	
//	public boolean validateData(NhanVien nv) {
//		if (nv.getMaNV().isEmpty() || nv.getTenNV().isEmpty() || nv.getDiaChi().isEmpty() || nv.getMatKhau().isEmpty()
//				|| nv.getSDT().isEmpty() || nv.getDiaChi().isEmpty() || nv.getChucVu().equals("") || nv.getGioiTinh().equals("")
//				|| nv.getHinhanh().equals("")) {
//			System.out.println(" chưa điền đầy đủ thông tin");
//			return false;
//		}
//
//		if (!(nv.getSDT().matches("\\d{10}"))) {
//			System.out.println("Số điện thoại không hợp lệ");
//			return false;
//		}
//
//		return true;
//	}
	
//	@Test
//	public void testAddNullCMND() {
//		NhanVien newEmployee = new NhanVien();
//		newEmployee.setMaNV("nv01");
//		newEmployee.setMatKhau("vanquyet");
//		newEmployee.setTenNV("Nguyeenx Van Quyet");
//		newEmployee.setSDT("043920323");
//		newEmployee.setDiaChi("Myx dduwc quang binh");
//		newEmployee.setChucVu(true);
//		newEmployee.setGioiTinh(true);
//		byte[] imageData = Files.readAllBytes(
//				Paths.get("D:\\BackUp\\Ky4\\MonDuAn1\\DuancoffeeFoply\\src\\main\\java\\ImageProduct\\7up.png"));
//		newEmployee.setHinhanh(imageData);
//		
//		
//		boolean expected = false;
//		boolean actual;
//		try {
//			if (validateData(newEmployee)) {
//				dao.insert(newEmployee);
//				NhanVien nvFound = dao.SelectByID(maNV);
//				actual = nvFound == null ? false : true;
//			} else
//				actual = false;
//		} catch (Exception e) {
//			System.out.println(e);
//			actual = false;
//		}
//
//		assertEquals(actual, expected);
//		System.out.println("fn testAddNullCMND OK !");
//	}

}
