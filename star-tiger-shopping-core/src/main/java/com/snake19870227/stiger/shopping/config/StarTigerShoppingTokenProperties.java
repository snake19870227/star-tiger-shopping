package com.snake19870227.stiger.shopping.config;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "stiger.shopping.token")
public class StarTigerShoppingTokenProperties {

    private String publicKey;
    private String privateKey;
    private Duration expirationTime = Duration.ofMinutes(30);

    private List<ExcludePath> excludePaths;

    @Getter
    @Setter
    public static class ExcludePath {

        private String pattern;

        private String method;
    }
}
