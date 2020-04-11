package com.snake19870227.stiger.shopping.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.snake19870227.stiger.shopping.entity.bo.AccountToken;
import com.snake19870227.stiger.shopping.entity.dto.AccountModel;
import com.snake19870227.stiger.shopping.entity.dto.TokenRestResponse;
import com.snake19870227.stiger.shopping.service.AccountService;
import com.snake19870227.stiger.web.exception.MvcException;
import com.snake19870227.stiger.web.restful.RestResponseBuilder;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/token")
    public TokenRestResponse getToken(@Valid @ModelAttribute AccountModel accountModel) {
        try {
            AccountToken token = accountService.checkAuth(accountModel.getAccountName(), accountModel.getAccountPassword());
            return RestResponseBuilder.createSuccessRestResp(token, TokenRestResponse.class);
        } catch (Exception e) {
            throw new MvcException("5003", e);
        }
    }
}
