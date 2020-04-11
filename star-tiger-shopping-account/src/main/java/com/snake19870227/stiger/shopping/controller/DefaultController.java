package com.snake19870227.stiger.shopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.snake19870227.stiger.shopping.entity.dto.AccountModel;
import com.snake19870227.stiger.shopping.entity.dto.AccountRestResponse;
import com.snake19870227.stiger.shopping.entity.mapper.EntityMapper;
import com.snake19870227.stiger.shopping.entity.po.ShoppingAccount;
import com.snake19870227.stiger.shopping.service.AccountService;
import com.snake19870227.stiger.web.exception.MvcException;
import com.snake19870227.stiger.web.restful.RestResponseBuilder;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@RestController
@RequestMapping(path = "/account")
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    private final EntityMapper entityMapper;

    private final AccountService accountService;

    public DefaultController(EntityMapper entityMapper, AccountService accountService) {
        this.entityMapper = entityMapper;
        this.accountService = accountService;
    }

    @GetMapping(path = "/{accountId}")
    public AccountRestResponse get(@PathVariable String accountId) {
        try {
            Assert.hasText(accountId, "账户ID不能为空");
            ShoppingAccount account = accountService.getById(accountId);
            return RestResponseBuilder.createSuccessRestResp(account, AccountRestResponse.class);
        } catch (Exception e) {
            throw new MvcException("5001", e);
        }
    }

    @PostMapping
    public AccountRestResponse add(@Valid @ModelAttribute AccountModel accountModel) {
        try {
            ShoppingAccount account = entityMapper.toAccountPo(accountModel);
            account = accountService.create(account);

            Assert.notNull(account, "数据库保存账户失败");

            return RestResponseBuilder.createSuccessRestResp(account, AccountRestResponse.class);
        } catch (Exception e) {
            throw new MvcException("5002", e);
        }
    }
}
