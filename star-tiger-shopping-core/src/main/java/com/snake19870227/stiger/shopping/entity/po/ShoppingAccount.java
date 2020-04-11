package com.snake19870227.stiger.shopping.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;

/**
 * <p>
 * 
 * </p>
 *
 * @author buhuayang
 * @since 2020-04-08
 */
@ApiModel(value="ShoppingAccount对象", description="")
public class ShoppingAccount implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "账户id")
    @TableId(value = "account_id", type = IdType.ASSIGN_UUID)
    private String accountId;

    @ApiModelProperty(value = "账户登录名")
    private String accountName;

    @ApiModelProperty(value = "账户登录密码")
    private String accountPassword;

    @ApiModelProperty(value = "删除标记")
    @TableLogic
    private String deleteFlag;


    public String getAccountId() {
        return accountId;
    }

    public ShoppingAccount setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public ShoppingAccount setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public ShoppingAccount setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
        return this;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public ShoppingAccount setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @Override
    public String toString() {
        return "ShoppingAccount{" +
        "accountId=" + accountId +
        ", accountName=" + accountName +
        ", accountPassword=" + accountPassword +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
