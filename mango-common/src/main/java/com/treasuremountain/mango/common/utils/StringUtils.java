package com.treasuremountain.mango.common.utils;

/**
 * 字符串工具类
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/5 0005 8:33
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

}
