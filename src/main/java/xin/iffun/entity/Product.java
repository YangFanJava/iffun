package xin.iffun.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Product {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品名称 荣耀8 V20
     */
    private String name;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 类型_id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 商品卖点 可添加多个
     */
    @Column(name = "sell_point")
    private String sellPoint;

    /**
     * 商品简介 用于列表展示
     */
    private String synopsis;

    /**
     * 搜索用关键字
     */
    private String keywords;

    /**
     * 图片 ,分割 第一张为主图
     */
    private String images;

    /**
     * 市场价 无型号时显示
     */
    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 优先级 排序控制
     */
    private Integer sort;

    /**
     * 是否热门 默认不热门
     */
    @Column(name = "is_hot")
    private Integer isHot;

    /**
     * 是否上架  默认不上架
     */
    @Column(name = "is_alive")
    private Integer isAlive;

    /**
     * 创建时间
     */
    private Date createtime;

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
     * 获取商品名称 荣耀8 V20
     *
     * @return name - 商品名称 荣耀8 V20
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称 荣耀8 V20
     *
     * @param name 商品名称 荣耀8 V20
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取品牌ID
     *
     * @return brand_id - 品牌ID
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置品牌ID
     *
     * @param brandId 品牌ID
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取类型_id
     *
     * @return category_id - 类型_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类型_id
     *
     * @param categoryId 类型_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品卖点 可添加多个
     *
     * @return sell_point - 商品卖点 可添加多个
     */
    public String getSellPoint() {
        return sellPoint;
    }

    /**
     * 设置商品卖点 可添加多个
     *
     * @param sellPoint 商品卖点 可添加多个
     */
    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    /**
     * 获取商品简介 用于列表展示
     *
     * @return synopsis - 商品简介 用于列表展示
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * 设置商品简介 用于列表展示
     *
     * @param synopsis 商品简介 用于列表展示
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * 获取搜索用关键字
     *
     * @return keywords - 搜索用关键字
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置搜索用关键字
     *
     * @param keywords 搜索用关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取图片 ,分割 第一张为主图
     *
     * @return images - 图片 ,分割 第一张为主图
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置图片 ,分割 第一张为主图
     *
     * @param images 图片 ,分割 第一张为主图
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取市场价 无型号时显示
     *
     * @return market_price - 市场价 无型号时显示
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置市场价 无型号时显示
     *
     * @param marketPrice 市场价 无型号时显示
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取优先级 排序控制
     *
     * @return sort - 优先级 排序控制
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置优先级 排序控制
     *
     * @param sort 优先级 排序控制
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否热门 默认不热门
     *
     * @return is_hot - 是否热门 默认不热门
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * 设置是否热门 默认不热门
     *
     * @param isHot 是否热门 默认不热门
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取是否上架  默认不上架
     *
     * @return is_alive - 是否上架  默认不上架
     */
    public Integer getIsAlive() {
        return isAlive;
    }

    /**
     * 设置是否上架  默认不上架
     *
     * @param isAlive 是否上架  默认不上架
     */
    public void setIsAlive(Integer isAlive) {
        this.isAlive = isAlive;
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
}