package com.snake19870227.stiger.shopping.service;

import com.snake19870227.stiger.shopping.entity.bo.AccountToken;
import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
public interface AccountService {

    ShoppingAccount getById(String id);

    ShoppingAccount getByName(String name);

    AccountToken checkAuth(String name, String password);

    ShoppingAccount create(ShoppingAccount account);
}
