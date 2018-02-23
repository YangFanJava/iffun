package xin.iffun.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "recyle_order")
public class RecyleOrder {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 下单用户
     */
    private Integer uid;

    /**
     * 回收手机类型
     */
    @Column(name = "price_id")
    private Integer priceId;

    /**
     * 回收进度 0 订单创建未联系客户 1订单创建已联系客户   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束
     */
    @Column(name = "recyle_state")
    private String recyleState;

    /**
     * 回收类型  0 上门回收 1 店面回收  2 快递回收 
     */
    @Column(name = "recyle_type")
    private String recyleType;

    /**
     * 回收问题 用户
     */
    @Column(name = "qa_user")
    private String qaUser;

    /**
     * 回收问题  商家重新测试
     */
    @Column(name = "qa_business")
    private String qaBusiness;

    /**
     * 回收价格 用户测算价格
     */
    @Column(name = "estimate_price_user")
    private BigDecimal estimatePriceUser;

    /**
     * 是否审核
     */
    @Column(name = "is_auditing")
    private String isAuditing;

    /**
     * 商家评估价格
     */
    @Column(name = "auditing_price")
    private BigDecimal auditingPrice;

    /**
     * 支付状态  0 未支付  1 已支付
     */
    @Column(name = "pay_state")
    private String payState;

    /**
     * 支付类型  1 微信  1 支付宝
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 支付名
     */
    @Column(name = "pay_name")
    private String payName;

    /**
     * 支付名
     */
    @Column(name = "pay_account")
    private String payAccount;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户联系方式
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 快递单号
     */
    @Column(name = "express_code")
    private String expressCode;

    /**
     * 预约地址  上门回收使用   
     */
    @Column(name = "appointment_address")
    private String appointmentAddress;

    /**
     * 预约时间
     */
    @Column(name = "appointment_time")
    private Date appointmentTime;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取下单用户
     *
     * @return uid - 下单用户
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置下单用户
     *
     * @param uid 下单用户
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取回收手机类型
     *
     * @return price_id - 回收手机类型
     */
    public Integer getPriceId() {
        return priceId;
    }

    /**
     * 设置回收手机类型
     *
     * @param priceId 回收手机类型
     */
    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    /**
     * 获取回收进度 0 订单创建未联系客户 1订单创建已联系客户   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束
     *
     * @return recyle_state - 回收进度 0 订单创建未联系客户 1订单创建已联系客户   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束
     */
    public String getRecyleState() {
        return recyleState;
    }

    /**
     * 设置回收进度 0 订单创建未联系客户 1订单创建已联系客户   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束
     *
     * @param recyleState 回收进度 0 订单创建未联系客户 1订单创建已联系客户   5 回收中 6 回收结束未付款 7 回收结束已付款 订单结束
     */
    public void setRecyleState(String recyleState) {
        this.recyleState = recyleState;
    }

    /**
     * 获取回收类型  0 上门回收 1 店面回收  2 快递回收 
     *
     * @return recyle_type - 回收类型  0 上门回收 1 店面回收  2 快递回收 
     */
    public String getRecyleType() {
        return recyleType;
    }

    /**
     * 设置回收类型  0 上门回收 1 店面回收  2 快递回收 
     *
     * @param recyleType 回收类型  0 上门回收 1 店面回收  2 快递回收 
     */
    public void setRecyleType(String recyleType) {
        this.recyleType = recyleType;
    }

    /**
     * 获取回收问题 用户
     *
     * @return qa_user - 回收问题 用户
     */
    public String getQaUser() {
        return qaUser;
    }

    /**
     * 设置回收问题 用户
     *
     * @param qaUser 回收问题 用户
     */
    public void setQaUser(String qaUser) {
        this.qaUser = qaUser;
    }

    /**
     * 获取回收问题  商家重新测试
     *
     * @return qa_business - 回收问题  商家重新测试
     */
    public String getQaBusiness() {
        return qaBusiness;
    }

    /**
     * 设置回收问题  商家重新测试
     *
     * @param qaBusiness 回收问题  商家重新测试
     */
    public void setQaBusiness(String qaBusiness) {
        this.qaBusiness = qaBusiness;
    }

    /**
     * 获取回收价格 用户测算价格
     *
     * @return estimate_price_user - 回收价格 用户测算价格
     */
    public BigDecimal getEstimatePriceUser() {
        return estimatePriceUser;
    }

    /**
     * 设置回收价格 用户测算价格
     *
     * @param estimatePriceUser 回收价格 用户测算价格
     */
    public void setEstimatePriceUser(BigDecimal estimatePriceUser) {
        this.estimatePriceUser = estimatePriceUser;
    }

    /**
     * 获取是否审核
     *
     * @return is_auditing - 是否审核
     */
    public String getIsAuditing() {
        return isAuditing;
    }

    /**
     * 设置是否审核
     *
     * @param isAuditing 是否审核
     */
    public void setIsAuditing(String isAuditing) {
        this.isAuditing = isAuditing;
    }

    /**
     * 获取商家评估价格
     *
     * @return auditing_price - 商家评估价格
     */
    public BigDecimal getAuditingPrice() {
        return auditingPrice;
    }

    /**
     * 设置商家评估价格
     *
     * @param auditingPrice 商家评估价格
     */
    public void setAuditingPrice(BigDecimal auditingPrice) {
        this.auditingPrice = auditingPrice;
    }

    /**
     * 获取支付状态  0 未支付  1 已支付
     *
     * @return pay_state - 支付状态  0 未支付  1 已支付
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 设置支付状态  0 未支付  1 已支付
     *
     * @param payState 支付状态  0 未支付  1 已支付
     */
    public void setPayState(String payState) {
        this.payState = payState;
    }

    /**
     * 获取支付类型  1 微信  1 支付宝
     *
     * @return pay_type - 支付类型  1 微信  1 支付宝
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型  1 微信  1 支付宝
     *
     * @param payType 支付类型  1 微信  1 支付宝
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取支付名
     *
     * @return pay_name - 支付名
     */
    public String getPayName() {
        return payName;
    }

    /**
     * 设置支付名
     *
     * @param payName 支付名
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /**
     * 获取支付名
     *
     * @return pay_account - 支付名
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 设置支付名
     *
     * @param payAccount 支付名
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户联系方式
     *
     * @return user_phone - 用户联系方式
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户联系方式
     *
     * @param userPhone 用户联系方式
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取快递单号
     *
     * @return express_code - 快递单号
     */
    public String getExpressCode() {
        return expressCode;
    }

    /**
     * 设置快递单号
     *
     * @param expressCode 快递单号
     */
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    /**
     * 获取预约地址  上门回收使用   
     *
     * @return appointment_address - 预约地址  上门回收使用   
     */
    public String getAppointmentAddress() {
        return appointmentAddress;
    }

    /**
     * 设置预约地址  上门回收使用   
     *
     * @param appointmentAddress 预约地址  上门回收使用   
     */
    public void setAppointmentAddress(String appointmentAddress) {
        this.appointmentAddress = appointmentAddress;
    }

    /**
     * 获取预约时间
     *
     * @return appointment_time - 预约时间
     */
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * 设置预约时间
     *
     * @param appointmentTime 预约时间
     */
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取订单修改时间
     *
     * @return update_time - 订单修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置订单修改时间
     *
     * @param updateTime 订单修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}