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
public class HopDong {
    int id;
    String ten;
    String mota;
    float tienCoc;
    String loaiTien;
    String ngayThue;
    String ngayTra;
    int idKhachHang;

    public HopDong() {
    }

    
    public HopDong(int id, String ten, String mota, float tienCoc, String loaiTien, String ngayThue, String ngayTra, int idKhachHang) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
        this.tienCoc = tienCoc;
        this.loaiTien = loaiTien;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.idKhachHang = idKhachHang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(float tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getLoaiTien() {
        return loaiTien;
    }

    public void setLoaiTien(String loaiTien) {
        this.loaiTien = loaiTien;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    
    
    
}
