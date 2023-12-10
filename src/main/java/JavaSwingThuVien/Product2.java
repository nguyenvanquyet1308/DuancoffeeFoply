package JavaSwingThuVien;

import DAO.*;

public class Product2 {

   // private String name;
   // private int qte;
   // private String price;
   // private int catId;\
    private String MaSP;
    private String TenSP;
    private float Gia;
    private String MaLoai;
    private String MoTa;
    private byte [] hinhanh;
    
    public Product2(){
    }

    public Product2(String MaSP, String TenSP, float Gia, String MaLoai, String MoTa, byte[] hinhanh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.MaLoai = MaLoai;
        this.MoTa = MoTa;
        this.hinhanh = hinhanh;
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

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }
}