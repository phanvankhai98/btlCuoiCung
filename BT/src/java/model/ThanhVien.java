/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author pvkha
 */
public class ThanhVien extends Nguoi{
    String username;
    String password;

    public ThanhVien(String username, String password, HoTen hoten, int id, DiaChi diaChi, String sdt, String email, Date ngaySinh, String ghiChu) {
        super(hoten, id, diaChi, sdt, email, ngaySinh, ghiChu);
        this.username = username;
        this.password = password;
    }

    public ThanhVien(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public ThanhVien() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
