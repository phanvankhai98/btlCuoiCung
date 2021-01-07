/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.taisan;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.TaiSan;

/**
 *
 * @author pvkha
 */
public class TaiSanDAO extends DAO {

    public TaiSanDAO() {
        super();
    }

    public List<TaiSan> getAllTaiSan() {
        List<TaiSan> list = new ArrayList<TaiSan>();

        String sql = "SELECT * FROM db_thue_xe.tbltaisan;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                TaiSan taiSan = new TaiSan();
                taiSan.setId(rs.getInt("id"));
                taiSan.setTenTaiSan(rs.getString("ten"));
                taiSan.setMoTa(rs.getString("mota"));
                list.add(taiSan);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public TaiSan getTaiSanByID(String id) {
        TaiSan taiSan = null ;
        String sql = "SELECT * FROM db_thue_xe.tbltaisan where id = ?;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, Integer.parseInt(id));
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                taiSan = new TaiSan();
                taiSan.setId(rs.getInt("id"));
                taiSan.setTenTaiSan(rs.getString("ten"));
                taiSan.setMoTa(rs.getString("mota"));
            }
        } catch (Exception e) {
        }
        return taiSan;
    }

    public boolean addTaiSan(TaiSan taiSan) {
        boolean kq = false;
        String sql = "INSERT INTO `db_thue_xe`.`tbltaisan` (`ten`, `mota`) VALUES (?, ?);";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            cs.setString(1, taiSan.getTenTaiSan());
            cs.setString(2, taiSan.getMoTa());
            kq = cs.executeUpdate() == 1;
        } catch (Exception e) {
        }
        return kq;
    }

}
