package xin.iffun.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_comment")
public class OrderComment {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 地区
     */
    @Column(name = "user_address")
    private String userAddress;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品图片
     */
    @Column(name = "product_image")
    private String productImage;

    /**
     * 订单id
     */
    private Integer oid;

    /**
     * 成交金额
     */
    @Column(name = "recyle_price")
    private BigDecimal recylePrice;

    /**
     * 评论正文
     */
    private String text;

    /**
     * 回收方式
     */
    @Column(name = "recyle_type")
    private String recyleType;

    /**
     * 创建时间
     */
    private Date createtime;

    @Column(name = "is_show")
    private String isShow;

    private Integer sort;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取地区
     *
     * @return user_address - 地区
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置地区
     *
     * @param userAddress 地区
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取商品id
     *
     * @return pid - 商品id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置商品id
     *
     * @param pid 商品id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品图片
     *
     * @return product_image - 商品图片
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 设置商品图片
     *
     * @param productImage 商品图片
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * 获取订单id
     *
     * @return oid - 订单id
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * 设置订单id
     *
     * @param oid 订单id
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * 获取成交金额
     *
     * @return recyle_price - 成交金额
     */
    public BigDecimal getRecylePrice() {
        return recylePrice;
    }

    /**
     * 设置成交金额
     *
     * @param recylePrice 成交金额
     */
    public void setRecylePrice(BigDecimal recylePrice) {
        this.recylePrice = recylePrice;
    }

    /**
     * 获取评论正文
     *
     * @return text - 评论正文
     */
    public String getText() {
        return text;
    }

    /**
     * 设置评论正文
     *
     * @param text 评论正文
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取回收方式
     *
     * @return recyle_type - 回收方式
     */
    public String getRecyleType() {
        return recyleType;
    }

    /**
     * 设置回收方式
     *
     * @param recyleType 回收方式
     */
    public void setRecyleType(String recyleType) {
        this.recyleType = recyleType;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return is_show
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}