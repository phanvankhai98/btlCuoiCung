/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.khachhang;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoTen;
import model.Nguoi;

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

        String sql = "SELECT * FROM db_thue_xe.tblnguoi where role = 2 and ten like ? ;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, name);
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

}
