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
public class Xe {
    int id;
    String tenXe;
    String moTa;
    String bienSO;
    double donGia;
    String hangXe;
    String dongXe;

    public Xe() {
    }

    public Xe(int id, String tenXe, String moTa, String bienSO, double donGia, String hangXe, String dongXe) {
        this.id = id;
        this.tenXe = tenXe;
        this.moTa = moTa;
        this.bienSO = bienSO;
        this.donGia = donGia;
        this.hangXe = hangXe;
        this.dongXe = dongXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getBienSO() {
        return bienSO;
    }

    public void setBienSO(String bienSO) {
        this.bienSO = bienSO;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }
    

  
}
