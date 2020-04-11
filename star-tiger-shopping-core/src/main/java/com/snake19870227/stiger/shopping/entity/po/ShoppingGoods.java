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
@ApiModel(value="ShoppingGoods对象", description="")
public class ShoppingGoods implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.ASSIGN_UUID)
    private String goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品生产厂家")
    private String goodsFactory;

    @ApiModelProperty(value = "商品说明")
    private String goodsContent;

    @ApiModelProperty(value = "商品标签")
    private String goodsKeyword;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "删除标记")
    @TableLogic
    private String deleteFlag;


    public String getGoodsId() {
        return goodsId;
    }

    public ShoppingGoods setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public ShoppingGoods setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getGoodsFactory() {
        return goodsFactory;
    }

    public ShoppingGoods setGoodsFactory(String goodsFactory) {
        this.goodsFactory = goodsFactory;
        return this;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public ShoppingGoods setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
        return this;
    }

    public String getGoodsKeyword() {
        return goodsKeyword;
    }

    public ShoppingGoods setGoodsKeyword(String goodsKeyword) {
        this.goodsKeyword = goodsKeyword;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public ShoppingGoods setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public ShoppingGoods setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    @Override
    public String toString() {
        return "ShoppingGoods{" +
        "goodsId=" + goodsId +
        ", goodsName=" + goodsName +
        ", goodsFactory=" + goodsFactory +
        ", goodsContent=" + goodsContent +
        ", goodsKeyword=" + goodsKeyword +
        ", goodsPrice=" + goodsPrice +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
