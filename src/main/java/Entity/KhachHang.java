/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nguyenvanquyet
 */
public class KhachHang {
    public String MaKH;
    public String TenKH;
    public String SDT;
    public String Maban;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String TenKH, String SDT, String Maban) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Maban = Maban;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaban() {
        return Maban;
    }

    public void setMaban(String Maban) {
        this.Maban = Maban;
    }

  

  
 
    
}
