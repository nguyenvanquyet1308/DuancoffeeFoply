/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author nguyenvanquyet
 */
public class Ban {

    String MaBan;
    Boolean TrangThai;

    public Ban() {
    }

    public Ban(String MaBan, Boolean TrangThai) {
        this.MaBan = MaBan;
        this.TrangThai = TrangThai;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

   

    @Override
    public String toString() {
        return String.valueOf(MaBan);
    }

}
