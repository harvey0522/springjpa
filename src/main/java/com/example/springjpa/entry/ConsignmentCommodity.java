package com.example.springjpa.entry;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * t_consignment_commodity
 * @author 
 */
@Data
@ToString
@Entity
@Table(name="t_consignment_commodity")
public class ConsignmentCommodity {
    @Id
    private Long id;

    /**
     * 商品编号
     */
    private String commodityNo;

    /**
     * 服务单编号
     */
    private String consignmentNo;

    /**
     * 商品标题
     */
    private String commodityTitle;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品描述
     */
    private String commodityDesc;

    /**
     * 商品状态 不可售卖，售卖中 ，已拍下，交易中，已售出 ，平台已退回
     */
    private String status;

    /**
     * 商品履约状态
     */
    private String performanceStatus;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 一级分类id
     */
    private String categoryFirstId;

    /**
     * 二级分类id
     */
    private String categorySecondId;

    /**
     * 卖家用户id
     */
    private String userId;

    /**
     * 用户期望售价
     */
    private BigDecimal saleExpectPrice;

    /**
     * 销售价面向客户
     */
    private BigDecimal salePriceToc;

    /**
     * 销售价面向企业
     */
    private BigDecimal salePriceTob;

    /**
     * 审核状态
     */
    private Integer auditStatus;

    /**
     * 业务类型
     */
    private Integer businessType;

    /**
     * 原商品rfid
     */
    private String originRfid;

    /**
     * 原商品卡rfid
     */
    private String rfCardId;

    /**
     * 系列编号
     */
    private String seriesNo;

    /**
     * 型号
     */
    private String modelNo;

    /**
     * 奢品身号（货号）
     */
    private String initialNo;

    /**
     * 视频 
     */
    private String vedioInfo;



    /**
     * 鉴定编号
     */
    private String appraisedNo;

    /**
     * 是否鉴定
     */
    private Byte isAppraised;

    /**
     * 仓库id
     */
    private String storeAddressId;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 删除标识
     */
    private Byte delFlag;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 版本号
     */
    private Integer version;

}