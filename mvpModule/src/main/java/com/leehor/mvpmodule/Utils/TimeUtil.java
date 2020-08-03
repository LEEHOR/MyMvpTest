package com.leehor.mvpmodule.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getStingYMDHM(long date){
        String startTime;
        Date d = new Date(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        startTime = sdf.format(d);
        return startTime;

    }
}
