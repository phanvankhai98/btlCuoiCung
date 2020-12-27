/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.nhanvien;

import dao.DAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DiaChi;
import model.HoTen;
import model.Nguoi;

/**
 *
 * @author pvkha
 */
public class NhanVienDAO extends DAO {

    public NhanVienDAO() {
        super();
    }

    public List<Nguoi> timKhachHangTheoTenKhachHang(String tenKhachHang) {
        List<Nguoi> list = new ArrayList<Nguoi>();

        String sql = "{call timKhachHang(?)}";

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1, tenKhachHang);
            ResultSet rs = cs.executeQuery();
            if (rs.next()){
                Nguoi ng = new Nguoi();
                ng.setId(rs.getInt("id"));
                HoTen ht = new HoTen();
                ht.setDem(rs.getString("dem"));
                ht.setTen(rs.getString("ten"));
                ht.setTen(rs.getString("ho"));
                DiaChi diaChi = new DiaChi();
                diaChi.setSoNha(rs.getString("sonha"));
                diaChi.setPhoXom(rs.getString("phoxom"));
                diaChi.setQuanHuyen(rs.getString("quanhuyen"));
                diaChi.setTinhTP(rs.getString("tinhtp"));
                ng.setHoten(ht);
                ng.setEmail(rs.getString("email"));
                ng.setGhiChu(rs.getString("ghichu"));
                ng.setSdt(rs.getString("sdt"));
                ng.setDiaChi(diaChi);
                list.add(ng);
            }
        } catch (Exception e) {
        }
        return list;
    }
//    public boolean themKhachHang(Nguoi nguoi){
//        
//    }
}
