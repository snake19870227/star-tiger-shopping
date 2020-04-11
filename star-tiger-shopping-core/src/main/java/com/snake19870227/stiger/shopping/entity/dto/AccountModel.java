package com.snake19870227.stiger.shopping.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/09
 */
@Getter
@Setter
@ToString
public class AccountModel implements Serializable {

    private static final long serialVersionUID = 5055944971091550056L;

    @ApiModelProperty(value = "账户id")
    private String accountId;

    @NotNull
    @Size(min = 5, max = 20)
    @ApiModelProperty(value = "账户登录名")
    private String accountName;

    @NotNull
    @ApiModelProperty(value = "账户登录密码")
    private String accountPassword;
}
