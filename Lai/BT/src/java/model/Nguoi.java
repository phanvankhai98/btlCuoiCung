/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author pvkha
 */
public class Nguoi {
    HoTen hoten;
    int id;
    DiaChi diaChi;
    String sdt;
    String email;
    String ngaySinh;
    String ghiChu;

    
    public Nguoi() {
    }

    public Nguoi(HoTen hoten, DiaChi diaChi, String sdt, String email, String ngaySinh, String ghiChu) {
        this.hoten = hoten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ghiChu = ghiChu;
    }

    
    public Nguoi(HoTen hoten, int id, DiaChi diaChi, String sdt, String email, String ngaySinh, String ghiChu) {
        this.hoten = hoten;
        this.id = id;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ghiChu = ghiChu;
    }

    
    public HoTen getHoten() {
        return hoten;
    }

    public void setHoten(HoTen hoten) {
        this.hoten = hoten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
  
}
