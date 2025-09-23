package com.blog_system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }




}
