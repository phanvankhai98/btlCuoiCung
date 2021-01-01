/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.thanhvien;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DiaChi;
import model.HoTen;
import model.ThanhVien;

/**
 *
 * @author pvkha
 */
public class ThanhVienDAO extends DAO {

    public ThanhVienDAO() {
        super();
    }

    public boolean kiemtraDangnhap(ThanhVien tv) {
        boolean kq = false;
//        if (tv.getUsername().contains("true")
//                || tv.getUsername().contains("=")
//                || tv.getPassword().contains("true")
//                || tv.getPassword().contains("=")) {
//            return false;
//        }
//SELECT * FROM db_thue_xe.tbthanhvien where username='user1' and password = 'password1';
        String sql = "SELECT * FROM db_thue_xe.tblnguoi,db_thue_xe.tbldiachi\n"
                + "where tblnguoi.role = 1 and tblnguoi.username = ? and password = ? \n"
                + "and tblnguoi.iddiachi = db_thue_xe.tbldiachi.id;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, tv.getUsername());
            cs.setString(2, tv.getPassword());
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                tv.setId(rs.getInt("id"));
                HoTen ht = new HoTen();
                ht.setDem(rs.getString("dem"));
                ht.setTen(rs.getString("ten"));
                ht.setHo(rs.getString("ho"));
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("xompho"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                tv.setHoten(ht);
                tv.setEmail(rs.getString("email"));
                tv.setGhiChu(rs.getString("ghichu"));
                tv.setSdt(rs.getString("sdt"));
                tv.setDiaChi(diaChi);
                kq = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }

    public List<ThanhVien> getAllKhachHang() {
        boolean kq = false;
        List<ThanhVien> listTV = new ArrayList<>();
        String sql = "SELECT * FROM db_thue_xe.tblnguoi,db_thue_xe.tbldiachi\n"
                + "where tblnguoi.role = 2 "
                + "and tblnguoi.iddiachi = db_thue_xe.tbldiachi.id;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                ThanhVien tv = new ThanhVien();
                tv.setId(rs.getInt("id"));
                HoTen ht = new HoTen();
                ht.setDem(rs.getString("dem"));
                ht.setTen(rs.getString("ten"));
                ht.setHo(rs.getString("ho"));
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("xompho"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                tv.setHoten(ht);
                tv.setEmail(rs.getString("email"));
                tv.setGhiChu(rs.getString("ghichu"));
                tv.setSdt(rs.getString("sdt"));
                tv.setDiaChi(diaChi);
                listTV.add(tv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTV;
    }

    public boolean themKhachHang(ThanhVien tv) {
        boolean kq = false;
        List<ThanhVien> listTV = new ArrayList<>();
        String sql = "INSERT INTO `db_thue_xe`.`tblnguoi` (`ho`, `ten`, `dem`, `ngaysinh`, `email`, `sdt`, `ghichu`, `role`, `iddiachi`) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, tv.getHoten().getHo());
            cs.setString(2, tv.getHoten().getTen());
            cs.setString(3, tv.getHoten().getDem());
            cs.setString(4, "1998-02-04");
            cs.setString(5, tv.getEmail());
            cs.setString(6, tv.getSdt());
            cs.setString(7, tv.getGhiChu());
            cs.setString(8, "2");
            cs.setString(9, "1");
            ResultSet rs = cs.executeQuery();
            kq = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static void main(String[] args) {
        try {
            //        ThanhVien tv = new ThanhVien("", "",new HoTen("Khai", "Phan", "Phan"), 0, new DiaChi(), "01222151544",
//        "pvkhaicd1998@gmail.com", new Date(0), "kkkk");
            String sDate1 = "31/12/1998";
            Date date1 =  new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            System.out.println(sDate1 + "\t" + date1.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
