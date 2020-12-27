/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hopdongxe;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HopDongXe;

/**
 *
 * @author pvkha
 */
public class HopDongXeDAO extends DAO {

    public HopDongXeDAO() {
        super();
    }

    public List<HopDongXe> getAll() {
        List<HopDongXe> list = new ArrayList<>();

//        SELECT * FROM db_thue_xe.tblhopdong;
        boolean kq = false;

        String sql = "SELECT * FROM db_thue_xe.tblhopdongxe;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                HopDongXe hdx = new HopDongXe();
                hdx.setId(rs.getInt("id"));
                hdx.setIdHopDong(rs.getInt("idhopdong"));
                hdx.setIdXe(rs.getInt("idxe"));
                list.add(hdx);
            }
        } catch (Exception e) {
        }
        return list;
    }
        public List<HopDongXe> getHopDongXeByIDHopDong(int idHopDong) {
        List<HopDongXe> list = new ArrayList<>();

//        SELECT * FROM db_thue_xe.tblhopdong;
        boolean kq = false;

        String sql = "SELECT * FROM db_thue_xe.tblhopdongxe where idhopdong = ?;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idHopDong);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                HopDongXe hdx = new HopDongXe();
                hdx.setId(rs.getInt("id"));
                hdx.setIdHopDong(rs.getInt("idhopdong"));
                hdx.setIdXe(rs.getInt("idxe"));
                list.add(hdx);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
