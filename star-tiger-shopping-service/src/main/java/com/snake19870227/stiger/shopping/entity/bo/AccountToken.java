package com.snake19870227.stiger.shopping.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class AccountToken implements Serializable {

    private static final long serialVersionUID = -22695733898715227L;

    @ApiModelProperty(value = "账户id")
    private String accountId;

    @ApiModelProperty(value = "账户授权token")
    private String token;
}
