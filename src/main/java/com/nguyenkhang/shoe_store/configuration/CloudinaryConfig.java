package com.nguyenkhang.shoe_store.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String cloudApiKey;

    @Value("${cloudinary.api_secret}")
    private String cloudApiSecret;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();

        config.put("cloud_name", cloudName);
        config.put("api_key", cloudApiKey);
        config.put("api_secret", cloudApiSecret);

        return new Cloudinary(config);
    }
}
