package com.snake19870227.stiger.shopping.opt.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;
import com.snake19870227.stiger.shopping.mapper.ShoppingAccountMapper;
import com.snake19870227.stiger.shopping.opt.AccountOpt;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
@Component
public class AccountOptImpl implements AccountOpt {

    private static final Logger logger = LoggerFactory.getLogger(AccountOptImpl.class);

    private final ShoppingAccountMapper accountMapper;

    public AccountOptImpl(ShoppingAccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public ShoppingAccount getByName(String name) {

        QueryWrapper<ShoppingAccount> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("account_name", name);

        return accountMapper.selectOne(queryWrapper);
    }
}
