package com.snake19870227.stiger.shopping.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.snake19870227.stiger.shopping.common.AuthTokenHandlerInterceptor;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/11
 */
@Configuration
public class AccountWebConfig {

    private static final Logger logger = LoggerFactory.getLogger(AccountWebConfig.class);

    private final StarTigerShoppingTokenProperties tokenProperties;

    public AccountWebConfig(StarTigerShoppingTokenProperties tokenProperties) {
        this.tokenProperties = tokenProperties;
    }

    @Configuration
    public static class AccountWebMvcConfig implements WebMvcConfigurer {

        private static final Logger logger = LoggerFactory.getLogger(AccountWebMvcConfig.class);

        private final AuthTokenHandlerInterceptor authTokenHandlerInterceptor;

        public AccountWebMvcConfig(AuthTokenHandlerInterceptor authTokenHandlerInterceptor) {
            this.authTokenHandlerInterceptor = authTokenHandlerInterceptor;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(authTokenHandlerInterceptor)
                    .addPathPatterns("/**")
            ;
        }

    }

    @Bean
    public AuthTokenHandlerInterceptor authTokenHandlerInterceptor() {
        return new AuthTokenHandlerInterceptor(tokenProperties);
    }
}
