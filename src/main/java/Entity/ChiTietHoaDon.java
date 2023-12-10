/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nguyenvanquyet
 */
public class ChiTietHoaDon {
    public int HoaDonCT;
    public String MaHD;
    public String MaSP;
    public String TenSP;
    public int SoLuong;
    public float GiaTien;
  

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int HoaDonCT, String MaHD, String MaSP, String TenSP, int SoLuong, float GiaTien  ) {
        this.HoaDonCT = HoaDonCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
    }

    public int getHoaDonCT() {
        return HoaDonCT;
    }

    public void setHoaDonCT(int HoaDonCT) {
        this.HoaDonCT = HoaDonCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

 
  

   

    
}
