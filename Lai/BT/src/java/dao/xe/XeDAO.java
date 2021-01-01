/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.xe;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Xe;

/**
 *
 * @author pvkha
 */
public class XeDAO extends DAO {

    public XeDAO() {
        super();
    }

//    SELECT db_thue_xe.tblxe.id,db_thue_xe.tblxe.ten, db_thue_xe.tblxe.mota, 
//db_thue_xe.tblhangxe.ten as tendong ,db_thue_xe.tbldongxe.ten as tenhang
// FROM db_thue_xe.tblxe, db_thue_xe.tblhangxe, db_thue_xe.tbldongxe
// where tblxe.iddongxe = tbldongxe.id and tbldongxe.idhangxe = tblhangxe.id;
    public List<Xe> getAll(){
     List<Xe> list = new ArrayList<>();
      String sql = "SELECT * FROM db_thue_xe.tblxe;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Xe xe = new Xe();
                xe.setId(rs.getInt("id"));
                xe.setTenXe(rs.getString("ten"));
                xe.setMoTa(rs.getString("ten"));
                xe.setDongXe(rs.getString("tendong"));
                xe.setHangXe(rs.getString("tenhang"));
                list.add(xe);
            }
        } catch (Exception e) {
        }
     return list;
    }
    
      public List<Xe> getXeBuyID(String ID){
     List<Xe> list = new ArrayList<>();
      String sql = "SELECT * FROM db_thue_xe.tblxe;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Xe xe = new Xe();
                xe.setId(rs.getInt("id"));
                xe.setTenXe(rs.getString("ten"));
                xe.setMoTa(rs.getString("ten"));
                xe.setDongXe(rs.getString("tendong"));
                xe.setHangXe(rs.getString("tenhang"));
                list.add(xe);
            }
        } catch (Exception e) {
        }
     return list;
    }
}
