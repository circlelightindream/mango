package com.treasuremountain.mango.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * POI相关操作
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/12/5 0005 8:25
 */
public class PoiUtils {

    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }

}
