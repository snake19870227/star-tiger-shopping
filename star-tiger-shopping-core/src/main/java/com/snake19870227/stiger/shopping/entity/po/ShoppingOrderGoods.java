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
@ApiModel(value="ShoppingOrderGoods对象", description="")
public class ShoppingOrderGoods implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "订单商品id")
    @TableId(value = "order_goods_id", type = IdType.ASSIGN_UUID)
    private String orderGoodsId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "商品id")
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "订单商品数量")
    private Integer goodsNum;

    @ApiModelProperty(value = "总价")
    private BigDecimal price;

    @ApiModelProperty(value = "删除标记")
    @TableLogic
    private String deleteFlag;


    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public ShoppingOrderGoods setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingOrderGoods setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public ShoppingOrderGoods setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public ShoppingOrderGoods setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public ShoppingOrderGoods setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public ShoppingOrderGoods setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShoppingOrderGoods setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public ShoppingOrderGoods setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @Override
    public String toString() {
        return "ShoppingOrderGoods{" +
        "orderGoodsId=" + orderGoodsId +
        ", orderId=" + orderId +
        ", goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", goodsPrice=" + goodsPrice +
        ", goodsNum=" + goodsNum +
        ", price=" + price +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
