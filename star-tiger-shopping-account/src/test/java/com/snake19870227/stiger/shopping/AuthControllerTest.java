package com.snake19870227.stiger.shopping;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.snake19870227.stiger.core.utils.JsonUtil;
import com.snake19870227.stiger.shopping.entity.dto.TokenRestResponse;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthControllerTest.class);

    @Resource
    private MockMvc mockMvc;

    @Test
    public void getTokenTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/auth/token")
                        .contentType("application/x-www-form-urlencoded")
                        .param("accountName", "snake")
                        .param("accountPassword", "123456")
        ).andDo(MockMvcResultHandlers.print());
    }
}
