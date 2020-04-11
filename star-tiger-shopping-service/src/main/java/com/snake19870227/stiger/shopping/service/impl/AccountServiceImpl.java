package com.snake19870227.stiger.shopping.service.impl;

import cn.hutool.crypto.asymmetric.RSA;
import io.jsonwebtoken.Jwts;

import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.snake19870227.stiger.core.context.StarTigerContext;
import com.snake19870227.stiger.core.exception.OptException;
import com.snake19870227.stiger.core.exception.ServiceException;
import com.snake19870227.stiger.shopping.config.StarTigerShoppingTokenProperties;
import com.snake19870227.stiger.shopping.entity.bo.AccountToken;
import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;
import com.snake19870227.stiger.shopping.mapper.ShoppingAccountMapper;
import com.snake19870227.stiger.shopping.opt.AccountOpt;
import com.snake19870227.stiger.shopping.service.AccountService;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final StarTigerShoppingTokenProperties tokenProperties;

    private final PasswordEncoder passwordEncoder;

    private final ShoppingAccountMapper accountMapper;

    private final AccountOpt accountOpt;

    public AccountServiceImpl(StarTigerShoppingTokenProperties tokenProperties,
                              PasswordEncoder passwordEncoder,
                              ShoppingAccountMapper accountMapper,
                              AccountOpt accountOpt) {
        this.tokenProperties = tokenProperties;
        this.passwordEncoder = passwordEncoder;
        this.accountMapper = accountMapper;
        this.accountOpt = accountOpt;
    }

    @Override
    public ShoppingAccount getById(String id) {
        return accountMapper.selectById(id);
    }

    @Override
    public ShoppingAccount getByName(String name) {
        ShoppingAccount account = accountOpt.getByName(name);
        if (account == null) {
            throw new OptException("账户'" + name + "'不存在");
        }
        return account;
    }

    @Override
    public AccountToken checkAuth(String name, String password) {
        ShoppingAccount account = accountOpt.getByName(name);
        if (account == null) {
            throw new OptException("账户'" + name + "'不存在");
        }
        if (passwordEncoder.matches(password, account.getAccountPassword())) {
            Instant iat = Instant.now();
            Instant exp = iat.plus(tokenProperties.getExpirationTime());

            RSA rsa = new RSA(tokenProperties.getPrivateKey(), tokenProperties.getPublicKey());
            String token = Jwts.builder()
                    .setIssuer(StarTigerContext.getApplicationName())
                    .setIssuedAt(Date.from(iat))
                    .setSubject(account.getAccountName())
                    .setAudience(account.getAccountName())
                    .setExpiration(Date.from(exp))
                    .setId(account.getAccountId())
                    .signWith(rsa.getPrivateKey())
                    .compact();

            return new AccountToken(account.getAccountId(), token);
        } else {
            throw new OptException("账户'" + name + "'密码错误");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShoppingAccount create(ShoppingAccount account) {
        ShoppingAccount existAccount = accountOpt.getByName(account.getAccountName());
        if (existAccount != null) {
            throw new ServiceException("账户名已存在");
        }
        account.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        if (accountMapper.insert(account) == 1) {
            return account;
        }
        return null;
    }
}
