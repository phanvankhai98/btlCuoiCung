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
public class HopDongXe {
    int id;
    int idHopDong;
    int idXe;

    public HopDongXe() {
    }

    public HopDongXe(int id, int idHopDong, int idXe) {
        this.id = id;
        this.idHopDong = idHopDong;
        this.idXe = idXe;
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

    public int getIdXe() {
        return idXe;
    }

    public void setIdXe(int idXe) {
        this.idXe = idXe;
    }
    
    
    
}
