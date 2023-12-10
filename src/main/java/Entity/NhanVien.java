/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nguyenvanquyet
 */
public class NhanVien {
    public String MaNV;
    public String MatKhau;
    public String TenNV;
    public String SDT;
    public String DiaChi;
    public Boolean ChucVu;
    public Boolean GioiTinh;
    public byte[] Hinhanh;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String MatKhau, String TenNV, String SDT, String DiaChi, Boolean GioiTinh, byte[] Hinhanh) {
        this.MaNV = MaNV;
        this.MatKhau = MatKhau;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.Hinhanh = Hinhanh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Boolean getChucVu() {
        return ChucVu;
    }

    public void setChucVu(Boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public byte[] getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(byte[] Hinhanh) {
        this.Hinhanh = Hinhanh;
    }

    
}
