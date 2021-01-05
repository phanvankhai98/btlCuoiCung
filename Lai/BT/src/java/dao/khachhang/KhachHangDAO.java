/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.khachhang;

import dao.DAO;
import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DiaChi;
import model.HoTen;
import model.Nguoi;
import model.ThanhVien;

/**
 *
 * @author pvkha
 */
public class KhachHangDAO extends DAO {

    public KhachHangDAO() {
        super();
    }

    public List<Nguoi> getAll() {
        List<Nguoi> list = new ArrayList();

        String sql = "SELECT * FROM db_thue_xe.tblnguoi where role = 2 ;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Nguoi nguoi = new Nguoi();
                nguoi.setId(rs.getInt("id"));
                HoTen ht = new HoTen(rs.getString("ten"), rs.getString("dem"), rs.getString("ho"));
                nguoi.setHoten(ht);
                nguoi.setEmail(rs.getString("email"));
                nguoi.setGhiChu(rs.getString("ghichu"));
                nguoi.setNgaySinh(rs.getString("ngaysinh"));
                list.add(nguoi);
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Nguoi> getKhachHangTheoTen(String name) {
        List<Nguoi> list = new ArrayList();
//SELECT * FROM db_thue_xe.tblnguoi where ten like '%';
        String sql = "SELECT * FROM db_thue_xe.tblnguoi,db_thue_xe.tbldiachi"
                + " where role = 2 and ten like ? and tbldiachi.id = tblnguoi.iddiachi;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, name + "%");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Nguoi nguoi = new Nguoi();
                nguoi.setId(rs.getInt("id"));
                HoTen ht = new HoTen(rs.getString("ten"), rs.getString("dem"), rs.getString("ho"));
                nguoi.setHoten(ht);
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("xompho"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                nguoi.setDiaChi(diaChi);
                nguoi.setSdt(rs.getString("sdt"));
                nguoi.setEmail(rs.getString("email"));
                nguoi.setGhiChu(rs.getString("ghichu"));
                nguoi.setNgaySinh(rs.getString("ngaysinh"));
                list.add(nguoi);
            }
        } catch (Exception e) {
        }

        return list;
    }

    public Nguoi getKhachHangByID(String id) {
        Nguoi data = null ;
//SELECT * FROM db_thue_xe.tblnguoi where ten like '%';
        String sql = "SELECT * FROM db_thue_xe.tblnguoi,db_thue_xe.tbldiachi"
                + " where role = 2 and tblnguoi.id = ? and tbldiachi.id = tblnguoi.iddiachi;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, Integer.parseInt(id));
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Nguoi nguoi = new Nguoi();
                nguoi.setId(rs.getInt("id"));
                HoTen ht = new HoTen(rs.getString("ten"), rs.getString("dem"), rs.getString("ho"));
                nguoi.setHoten(ht);
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("xompho"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                nguoi.setDiaChi(diaChi);
                nguoi.setSdt(rs.getString("sdt"));
                nguoi.setEmail(rs.getString("email"));
                nguoi.setGhiChu(rs.getString("ghichu"));
                nguoi.setNgaySinh(rs.getString("ngaysinh"));
                data = nguoi;
            }
        } catch (Exception e) {
        }

        return data;
    }

    public boolean themKhachHang(Nguoi nguoi) {
        boolean kq = false;
        String sql = "INSERT INTO `db_thue_xe`.`tblnguoi` (`ho`, `ten`, `dem`, `ngaysinh`, `email`, `sdt`, `ghichu`, `role`, `iddiachi`) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, nguoi.getHoten().getHo());
            cs.setString(2, nguoi.getHoten().getTen());
            cs.setString(3, nguoi.getHoten().getDem());
            cs.setString(4, "1998-02-04");
            cs.setString(5, nguoi.getEmail());
            cs.setString(6, nguoi.getSdt());
            cs.setString(7, nguoi.getGhiChu());
            cs.setString(8, "2");
            cs.setString(9, "1");
            kq = cs.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public List<Nguoi> getAllKhachHang() {
        boolean kq = false;
        List<Nguoi> listTV = new ArrayList<>();
        String sql = "SELECT * FROM db_thue_xe.tblnguoi,db_thue_xe.tbldiachi\n"
                + "where tblnguoi.role = 2 "
                + "and tblnguoi.iddiachi = db_thue_xe.tbldiachi.id;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Nguoi nguoi = new Nguoi();
                nguoi.setId(rs.getInt("id"));
                HoTen ht = new HoTen();
                ht.setDem(rs.getString("dem"));
                ht.setTen(rs.getString("ten"));
                ht.setHo(rs.getString("ho"));
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("xompho"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                nguoi.setDiaChi(diaChi);
                nguoi.setHoten(ht);
                nguoi.setEmail(rs.getString("email"));
                nguoi.setGhiChu(rs.getString("ghichu"));
                nguoi.setSdt(rs.getString("sdt"));
                listTV.add(nguoi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTV;
    }

    public static void main(String[] args) {
        try {
            Nguoi ng = new Nguoi(new HoTen("khai", "van", "phan"), new DiaChi(), "01122121",
                    "ákjdk@gmail.com", "2020-02-25", "kkkk");
            KhachHangDAO dao = new KhachHangDAO();

            System.out.println(dao.themKhachHang(ng));
            String sDate1 = "31/12/1998";
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            System.out.println(sDate1 + "\t" + date1.toString());
        } catch (ParseException ex) {
        }
    }
}
