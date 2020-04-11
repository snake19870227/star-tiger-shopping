package com.snake19870227.stiger.shopping.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.snake19870227.stiger.shopping.entity.dto.AccountModel;
import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@Mapper(
        componentModel = "spring"
)
public interface EntityMapper {

    @Mapping(target = "accountId", source = "accountId")
    @Mapping(target = "accountName", source = "accountName")
    @Mapping(target = "accountPassword", source = "accountPassword")
    ShoppingAccount toAccountPo(AccountModel accountModel);
}
