package com.example.book.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class DateUtils {

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


    public static String getDateString() {
        Date date = new Date();
        return dateToString(date);
    }

    public static String getUUIDDate() {
        Date date = new Date();
        return UUID.randomUUID().toString()+"_"+date.getYear()+date.getMonth()+date.getDate()
                +date.getHours()+date.getMinutes()+date.getSeconds();
    }
}
