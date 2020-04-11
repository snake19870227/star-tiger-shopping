package com.snake19870227.stiger.shopping.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@Configuration
@EnableConfigurationProperties(StarTigerShoppingTokenProperties.class)
public class GlobalConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
