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
    
    public List<HopDong> getAll(){
        List<HopDong> list = new ArrayList<>();
        
//        SELECT * FROM db_thue_xe.tblhopdong;
        boolean kq = false;

        String sql = "SELECT * FROM db_thue_xe.tblhopdong;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()){
                HopDong hd = new HopDong();
                hd.setId(rs.getInt("id"));
                hd.setTen(rs.getString("ten"));
                hd.setMota(rs.getString("mota"));
                hd.setTienCoc(rs.getFloat("tiencoc"));
                hd.setNgayThue(rs.getDate("ngaythue").toString());
                hd.setNgayTra(rs.getDate("ngaytra").toString());
                hd.setIdKhachHang(rs.getInt("idkhachhang"));
                list.add(hd);
            }
        } catch (Exception e) {
        }
        return  list;
        
    }
    
}
