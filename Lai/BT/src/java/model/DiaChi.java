package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pvkha
 */
public class DiaChi {
    int id;
    String soNha;
    String phoXom;
    String quanHuyen;
    String tinhTP;

    public DiaChi(int id, String soNha, String phoXom, String quanHuyen, String tinhTP) {
        this.id = id;
        this.soNha = soNha;
        this.phoXom = phoXom;
        this.quanHuyen = quanHuyen;
        this.tinhTP = tinhTP;
    }
    public String getDiaChi() {
        return soNha+","+phoXom+","+quanHuyen+","+tinhTP;
    }
    
    public DiaChi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getPhoXom() {
        return phoXom;
    }

    public void setPhoXom(String phoXom) {
        this.phoXom = phoXom;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getTinhTP() {
        return tinhTP;
    }

    public void setTinhTP(String tinhTP) {
        this.tinhTP = tinhTP;
    }
    
}
