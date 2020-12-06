package com.treasuremountain.mango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间相关工具
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/5 0005 8:08
 */
public class DateTimesUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     *
     * @return
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化时间
     *
     * @param date
     * @return
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }

}
