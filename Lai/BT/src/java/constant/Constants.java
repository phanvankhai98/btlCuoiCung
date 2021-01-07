/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pvkha
 */
public class Constants {

    final static public String USER_SESSION = "user";

    public static String convertTime(String time) {
        Date date = new Date(Long.parseLong(time));
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    public static void main(String[] args) {
        System.out.println(convertTime("1610557200000"));
    }
}
