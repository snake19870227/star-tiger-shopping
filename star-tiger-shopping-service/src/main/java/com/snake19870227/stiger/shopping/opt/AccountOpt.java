package com.snake19870227.stiger.shopping.opt;

import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
public interface AccountOpt {

    ShoppingAccount getByName(String name);
}
