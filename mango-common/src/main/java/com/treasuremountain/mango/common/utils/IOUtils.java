package com.treasuremountain.mango.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/5 0005 8:22
 */
public class IOUtils {

    /**
     * 关闭对象，连接
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioException) {
            // ignore
        }
    }

}
