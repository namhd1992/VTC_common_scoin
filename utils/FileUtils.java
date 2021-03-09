/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vtc.common.constant.Constant;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Aug 30, 2018
 */
public class FileUtils {
    
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static void deleteFileServer(File fileLocal) {
        if (!fileLocal.isDirectory()) {
            if (fileLocal.isFile()) {
                fileLocal.delete();
                logger.info("Delete file : [" + fileLocal.getName() + "] successful");
                fileLocal.getParentFile().delete();
                logger.info("Delete folder : [" + fileLocal.getParentFile().getName() + "] successful");
                return;
            }
        }
        
        File[] listFile = fileLocal.listFiles();
        if (listFile.length != Constant.LENGHT_FILE_OF_FOLDER_EMPTY) {
            for (File file : listFile) {
                try {
                    file.delete();
                    logger.info("Delete file : [" + file.getName() + "] successful");
                } catch (Exception e) {
                    logger.info("Can't Delete file : [" + file.getName() + "]");
                    return;
                }
            }
        }
        
        fileLocal.delete();
        logger.info("Delete folder and file : [" + fileLocal.getName() + "] successful");
    }

}
