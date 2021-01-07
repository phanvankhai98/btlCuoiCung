/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.hopdongtaisan;

import static dao.DAO.con;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HopDongTaiSan;

/**
 *
 * @author pvkha
 */
public class HopDongTaiSanDAO {

    public HopDongTaiSanDAO() {
        super();
    }
    public List<HopDongTaiSan> getHopDongTSByIDHopDong(int idHopDong) {
        List<HopDongTaiSan> list = new ArrayList<>();


        String sql = "SELECT * FROM db_thue_xe.tblhopdongtaisan where idhopdong = ?;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, idHopDong);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                HopDongTaiSan hdts = new HopDongTaiSan();
                hdts.setId(rs.getInt("id"));
                hdts.setIdHopDong(rs.getInt("idhopdong"));
                hdts.setIdTaiSan(rs.getInt("idtaisan"));
                list.add(hdts);
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    public boolean addHopDongTaiSan(HopDongTaiSan hdts) {
        boolean kq = false;
        String sql = "INSERT INTO `db_thue_xe`.`tblhopdongtaisan` (`idhopdong`, `idtaisan`) VALUES (?, ?);";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setInt(1, hdts.getIdHopDong());
            cs.setInt(1, hdts.getIdTaiSan());
            ResultSet rs = cs.executeQuery();
            kq = cs.executeUpdate() == 1;
        } catch (Exception e) {
        }
        return kq;
    }

}
