/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.xe;

import dao.DAO;
import dao.hopdong.HopDongDAO;
import dao.hopdongxe.HopDongXeDAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HopDong;
import model.HopDongXe;
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
    public List<Xe> getAll() {
        List<Xe> list = new ArrayList<>();
        String sql = "SELECT tblxe.id,tblxe.ten,tblxe.mota,tbldongxe.ten as dongxe, tblhangxe.ten as hangxe\n"
                + "FROM db_thue_xe.tblxe,db_thue_xe.tbldongxe,db_thue_xe.tblhangxe \n"
                + "where tbldongxe.id = tblxe.iddongxe and tblhangxe.id = tbldongxe.idhangxe;";
        try {
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Xe xe = new Xe();
                xe.setId(rs.getInt("id"));
                xe.setTenXe(rs.getString("ten"));
                xe.setMoTa(rs.getString("mota"));
                xe.setDongXe(rs.getString("dongxe"));
                xe.setHangXe(rs.getString("hangxe"));
                list.add(xe);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Xe> getXeBuyID(String ID) {
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

    public List<Xe> timXeTheoNgay(int ngayThue, int ngayTra) {
        List<Xe> listXe = getAll();
        List<Integer> idXe = new ArrayList<>();
        HopDongXeDAO hdxDAO = new HopDongXeDAO();
        List<HopDongXe> listhdx = hdxDAO.getAll();
        HopDongDAO hdDAO = new HopDongDAO();
        if (!listhdx.isEmpty()) {
            for (HopDongXe hdx : listhdx) {
                HopDong hd = hdDAO.getHopDongByID("" + hdx.getId());
                if (ngayThue > Integer.parseInt(hd.getNgayThue()) && ngayThue < Integer.parseInt(hd.getNgayTra())) {
                    idXe.add(hdx.getId());
                    if (!idXe.isEmpty() && !listXe.isEmpty()) {
                        for (Xe xe : listXe) {
                            if (xe.getId() == hdx.getId()) {
                                listXe.remove(listXe.indexOf(xe));
                                if(listXe.isEmpty()) break;
                            }
                        }
                    }
                } else if (ngayTra > Integer.parseInt(hd.getNgayThue()) && ngayTra < Integer.parseInt(hd.getNgayTra())) {
                    idXe.add(hdx.getId());
                    if (!idXe.isEmpty() && !listXe.isEmpty()) {
                        for (Xe xe : listXe) {
                            if (xe.getId() == hdx.getId()) {
                                listXe.remove(listXe.indexOf(xe));
                                 if(listXe.isEmpty()) break;
                            }
                        }
                    }
                } else if (ngayThue < Integer.parseInt(hd.getNgayThue()) && ngayTra > Integer.parseInt(hd.getNgayTra())) {
                    idXe.add(hdx.getId());
                    if (!idXe.isEmpty() && !listXe.isEmpty()) {
                        for (Xe xe : listXe) {
                            if (xe.getId() == hdx.getId()) {
                                listXe.remove(listXe.indexOf(xe));
                                 if(listXe.isEmpty()) break;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }

        }

        return listXe;
    }

    public static void main(String[] args) {
        XeDAO xe = new XeDAO();
        xe.timXeTheoNgay(20133010, 20133110);
    }
}
