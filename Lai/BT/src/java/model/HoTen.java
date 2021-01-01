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
public class HoTen {
    String ten;
    String dem;
    String ho;

    public HoTen() {
    }

    
    public String getHoVaTen() {
        return ho+" "+dem+" "+ten;
    }
    
    
    public HoTen(String ten, String dem, String ho) {
        this.ten = ten;
        this.dem = dem;
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDem() {
        return dem;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }
    
}
