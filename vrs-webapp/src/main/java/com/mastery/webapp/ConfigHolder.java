/**
 * 
 */
package com.mastery.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * webapp的一些配置
 * 
 * @author zouziwen
 * 
 */
@Service("configHolder")
public class ConfigHolder {

    /**
     * 上传临时路径
     */
    @Value("${upload.temp}")
    private String uploadTemp;

    /**
     * 上传路径
     */
    @Value("${upload.dir}")
    private String uploadDir;


    public final String getUploadTemp() {
        return uploadTemp;
    }

    public final String getUploadDir() {
        return uploadDir;
    }

}