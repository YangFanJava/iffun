package xin.iffun.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_price")
public class ProductPrice {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品主键
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 版本全名  例 4/64G 3/32G
     */
    private String version;

    /**
     * 市场价/标价
     */
    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 售出价
     */
    @Column(name = "sale_price")
    private BigDecimal salePrice;

    /**
     * 回收价
     */
    @Column(name = "recover_price")
    private BigDecimal recoverPrice;

    /**
     * 拥有颜色 ,分割
     */
    private String color;

    /**
     * 图片 详情显示时替代文字与主图替换
     */
    private String image;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 是否使用 默认使用
     */
    @Column(name = "is_use")
    private Integer isUse;

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
     * 获取商品主键
     *
     * @return product_id - 商品主键
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品主键
     *
     * @param productId 商品主键
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取版本全名  例 4/64G 3/32G
     *
     * @return version - 版本全名  例 4/64G 3/32G
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本全名  例 4/64G 3/32G
     *
     * @param version 版本全名  例 4/64G 3/32G
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取市场价/标价
     *
     * @return market_price - 市场价/标价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置市场价/标价
     *
     * @param marketPrice 市场价/标价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取售出价
     *
     * @return sale_price - 售出价
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     * 设置售出价
     *
     * @param salePrice 售出价
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 获取回收价
     *
     * @return recover_price - 回收价
     */
    public BigDecimal getRecoverPrice() {
        return recoverPrice;
    }

    /**
     * 设置回收价
     *
     * @param recoverPrice 回收价
     */
    public void setRecoverPrice(BigDecimal recoverPrice) {
        this.recoverPrice = recoverPrice;
    }

    /**
     * 获取拥有颜色 ,分割
     *
     * @return color - 拥有颜色 ,分割
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置拥有颜色 ,分割
     *
     * @param color 拥有颜色 ,分割
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取图片 详情显示时替代文字与主图替换
     *
     * @return image - 图片 详情显示时替代文字与主图替换
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片 详情显示时替代文字与主图替换
     *
     * @param image 图片 详情显示时替代文字与主图替换
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取库存
     *
     * @return stock - 库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存
     *
     * @param stock 库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取是否使用 默认使用
     *
     * @return is_use - 是否使用 默认使用
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置是否使用 默认使用
     *
     * @param isUse 是否使用 默认使用
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
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