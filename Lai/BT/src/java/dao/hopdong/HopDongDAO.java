/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hopdong;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HopDong;

/**
 *
 * @author pvkha
 */
public class HopDongDAO extends DAO {

    public HopDongDAO() {
        super();
    }

    public List<HopDong> getAll() {
        List<HopDong> list = new ArrayList<>();

//        SELECT * FROM db_thue_xe.tblhopdong;
        boolean kq = false;

        String sql = "SELECT * FROM db_thue_xe.tblhopdong;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setId(rs.getInt("id"));
                hd.setTen(rs.getString("ten"));
                hd.setMota(rs.getString("mota"));
                hd.setTienCoc(rs.getFloat("tiencoc"));
                hd.setNgayThue(rs.getString("ngaythue"));
                hd.setNgayTra(rs.getString("ngaytra"));
                hd.setIdKhachHang(rs.getInt("idkhachhang"));
                list.add(hd);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public HopDong getHopDongByID(String id) {
        HopDong hd = null;

//        SELECT * FROM db_thue_xe.tblhopdong;
        boolean kq = false;

        String sql = "SELECT * FROM db_thue_xe.tblhopdong where id = ?;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, id);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                hd = new HopDong();
                hd.setId(rs.getInt("id"));
                hd.setTen(rs.getString("ten"));
                hd.setMota(rs.getString("mota"));
                hd.setTienCoc(rs.getFloat("tiencoc"));
                hd.setNgayThue(rs.getString("ngaythue"));
                hd.setNgayTra(rs.getString("ngaytra"));
                hd.setIdKhachHang(rs.getInt("idkhachhang"));
            }
        } catch (Exception e) {
        }
        return hd;

    }
}
