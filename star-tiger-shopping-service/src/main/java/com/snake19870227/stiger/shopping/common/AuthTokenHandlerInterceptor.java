package com.snake19870227.stiger.shopping.common;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.RSA;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import com.snake19870227.stiger.core.StarTigerConstant;
import com.snake19870227.stiger.shopping.config.StarTigerShoppingTokenProperties;
import com.snake19870227.stiger.web.exception.MvcException;
import com.snake19870227.stiger.web.utils.WebUtil;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/11
 */
public class AuthTokenHandlerInterceptor implements HandlerInterceptor, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenHandlerInterceptor.class);

    private final StarTigerShoppingTokenProperties tokenProperties;

    private List<AntPathRequestMatcher> excludePathMatchers;

    public AuthTokenHandlerInterceptor(StarTigerShoppingTokenProperties tokenProperties) {
        this.tokenProperties = tokenProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (excludeMatchs(request)) {
            return true;
        }

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StrUtil.isBlank(header)) {
            throw new MvcException("4001");
        }

        if (!StrUtil.startWithIgnoreCase(header, StarTigerConstant.OAuth20Code.BEARER_TOKEN_PREFIX)) {
            throw new MvcException("4002");
        }

        String token = header.replace(StarTigerConstant.OAuth20Code.BEARER_TOKEN_PREFIX, "");

        if (StrUtil.isBlank(token)) {
            throw new MvcException("4002");
        }

        RSA rsa = new RSA(tokenProperties.getPrivateKey(), tokenProperties.getPublicKey());
        try {
            Jwts.parser().setSigningKey(rsa.getPublicKey()).parseClaimsJws(token);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new MvcException("4002", e);
        }

        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollUtil.isNotEmpty(tokenProperties.getExcludePaths())) {
            excludePathMatchers = new ArrayList<>(tokenProperties.getExcludePaths().size());
            tokenProperties.getExcludePaths().forEach(excludePath -> {
                if (StrUtil.isNotBlank(excludePath.getMethod())) {
                    String httpMethod = excludePath.getMethod().toUpperCase();
                    excludePathMatchers.add(new AntPathRequestMatcher(excludePath.getPattern(), httpMethod));
                } else {
                    excludePathMatchers.add(new AntPathRequestMatcher(excludePath.getPattern()));
                }
            });
        }
    }

    private boolean excludeMatchs(HttpServletRequest request) {
        if (CollUtil.isNotEmpty(excludePathMatchers)) {
            for (AntPathRequestMatcher pathMatcher : excludePathMatchers) {
                if (pathMatcher.matches(request)) {
                    return true;
                }
            }
        }
        return false;
    }
}
