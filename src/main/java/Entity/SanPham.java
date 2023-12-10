
package Entity;

/**
 *
 * @author nguyenvanquyet
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private float Gia;
    private String MaLoai;
    private String MoTa;
    private byte [] hinhanh;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, float Gia, String MaLoai, String MoTa, byte [] hinhanh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.MaLoai = MaLoai;
        this.MoTa = MoTa;
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
    public byte [] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte [] hinhanh) {
        this.hinhanh = hinhanh;
    }
}
