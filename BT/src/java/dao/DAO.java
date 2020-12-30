package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    public static Connection con;

    public DAO() {
        if (con == null) {
            String dbUrl = "jdbc:mysql://localhost:3307/db_thue_xe?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.jdbc.Driver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "root",
                        "minhduc97");
                System.out.println("Connect database success!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
    }
}
