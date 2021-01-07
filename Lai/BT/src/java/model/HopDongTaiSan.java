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
public class HopDongTaiSan {

    int id;
    int idHopDong;
    int idTaiSan;

    public HopDongTaiSan() {
    }

    public HopDongTaiSan(int id, int idHopDong, int idTaiSan) {
        this.id = id;
        this.idHopDong = idHopDong;
        this.idTaiSan = idTaiSan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdTaiSan() {
        return idTaiSan;
    }

    public void setIdTaiSan(int idTaiSan) {
        this.idTaiSan = idTaiSan;
    }

    
}
