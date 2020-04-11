package com.snake19870227.stiger.shopping.entity.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author buhuayang
 * @since 2020-04-08
 */
@ApiModel(value="ShoppingOrder对象", description="")
public class ShoppingOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.ASSIGN_UUID)
    private String orderId;

    @ApiModelProperty(value = "下单订单时间")
    private String orderDatetime;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "删除标记")
    @TableLogic
    private String deleteFlag;


    public String getOrderId() {
        return orderId;
    }

    public ShoppingOrder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public ShoppingOrder setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
        return this;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public ShoppingOrder setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public ShoppingOrder setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @Override
    public String toString() {
        return "ShoppingOrder{" +
        "orderId=" + orderId +
        ", orderDatetime=" + orderDatetime +
        ", orderPrice=" + orderPrice +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
