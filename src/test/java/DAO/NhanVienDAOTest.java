package DAO;

import org.junit.rules.ErrorCollector;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NhanVienDAOTest {
	NhanVienDAO dao = new NhanVienDAO();
	public ErrorCollector ec = new ErrorCollector();

	@Test
	public void CheckLoginTest() {

		String username = "Quyetnv";
		String password = "1234";
		boolean expected  = true;
		boolean result = dao.CheckLogin(username, password) != null;
		try {
			Assert.assertEquals(expected , result);
		} catch (Exception e) {
			// TODO: handle exception
			ec.addError(new Throwable("lỗi check: " + e));
		}

	}

	@Test
	public void CheckLoginTest1() {
		String username = "nhom3";
		String password = "00000";
		boolean expected  = false;
		boolean result = dao.CheckLogin(username, password) != null;
		try {
			Assert.assertEquals(expected , result);
		} catch (Exception e) {
			// TODO: handle exception
			ec.addError(new Throwable("lỗi check: " + e));
		}

	}
	@Test
	public void CheckLoginTest2() {
		String username = "";
		String password = "";
		boolean expected  = false;
		boolean result = dao.CheckLogin(username, password) != null;
		try {
			Assert.assertEquals(expected , result);
		} catch (Exception e) {
			// TODO: handle exception
			ec.addError(new Throwable("lỗi check: " + e));
		}

	}
	@Test
	public void CheckLoginTes3t() {
		String username = "";
		String password = "123";
		boolean expected  = false;
		boolean result = dao.CheckLogin(username, password) != null;
		try {
			Assert.assertEquals(expected , result);
		} catch (Exception e) {
			// TODO: handle exception
			ec.addError(new Throwable("lỗi check: " + e));
		}

	}
	@Test
	public void CheckLoginTest4() {
		String username = "Quyetnv";
		String password = "";
		boolean expected  = false;
		boolean result = dao.CheckLogin(username, password) != null;
		try {
			Assert.assertEquals(expected , result);
		} catch (Exception e) {
			// TODO: handle exception
			ec.addError(new Throwable("lỗi check: " + e));
		}

	}

}
