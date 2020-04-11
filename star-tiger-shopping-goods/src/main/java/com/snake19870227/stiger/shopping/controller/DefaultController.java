package com.snake19870227.stiger.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.snake19870227.stiger.web.restful.RestResponse;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@RestController
@RequestMapping(path = "/goods")
public class DefaultController {

    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @GetMapping(path = "/{goodsId}")
    public RestResponse.DefaultRestResponse get(@PathVariable String goodsId) {
        return null;
    }
}
