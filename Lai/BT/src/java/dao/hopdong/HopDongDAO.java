/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hopdong;

import dao.DAO;
import dao.hopdongtaisan.HopDongTaiSanDAO;
import dao.hopdongxe.HopDongXeDAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HopDong;
import model.HopDongTaiSan;
import model.HopDongXe;

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

    public boolean addHopDong(HopDong hopDong, List<String> listIDXe, List<String> listTaiSan) {
        boolean kq = false;

        String sql = "INSERT INTO `db_thue_xe`.`tblhopdong` (`ten`, `mota`, `tiencoc`, `loaitien`, `ngaythue`, `ngaytra`, `idkhachhang`)"
                + " VALUES ('thuê xe', 'thuê xe', ?, ?, '?, ?, ?);";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setDouble(1, hopDong.getTienCoc());
            cs.setString(2, hopDong.getLoaiTien());
            cs.setString(3, hopDong.getNgayThue());
            cs.setString(4, hopDong.getNgayTra());
            cs.setInt(5, hopDong.getIdKhachHang());
            if (cs.executeUpdate() == 0) {
                return false;
            };

            ResultSet rs = cs.getGeneratedKeys();
            if (rs.next()) {
                HopDongXeDAO hdxDAO = new HopDongXeDAO();
                HopDongTaiSanDAO hdtsDAO = new HopDongTaiSanDAO();
                int id = rs.getInt(1);
                for (String idXe : listIDXe) {
                    HopDongXe hdx = new HopDongXe(1, Integer.parseInt(idXe), id);
                    if (hdxDAO.addHopDongXe(hdx)) {
                        return false;
                    }
                }
                for (String idTS : listTaiSan) {
                    HopDongTaiSan hdts = new HopDongTaiSan(1, Integer.parseInt(idTS), id);
                    if (hdtsDAO.addHopDongTaiSan(hdts)) {
                        return false;
                    }
                }
            }

        } catch (Exception e) {
        }
        return kq;

    }
}
