package com.veysel.java11springmaraton.fileServer.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    public String toTurnStringAvatar(MultipartFile file) {
        Map config = new HashMap();
        config.put("cloud_name", "dy2oqy36j");
        config.put("api_key", "696219342455636");
        config.put("api_secret", "FENVYzUWL6LDf9ThMbceMUFw398");
        Cloudinary cloudinary = new Cloudinary(config);
        try {
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String url = (String) result.get("url");
            System.out.println(url + " --------------------------");
            return url;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
