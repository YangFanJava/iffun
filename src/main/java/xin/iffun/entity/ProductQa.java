package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_qa")
public class ProductQa {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题主键
     */
    @Column(name = "qa_id")
    private Integer qaId;

    /**
     * 商品主键
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 分值/负数
     */
    private Integer score;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取问题主键
     *
     * @return qa_id - 问题主键
     */
    public Integer getQaId() {
        return qaId;
    }

    /**
     * 设置问题主键
     *
     * @param qaId 问题主键
     */
    public void setQaId(Integer qaId) {
        this.qaId = qaId;
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
     * 获取分值/负数
     *
     * @return score - 分值/负数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置分值/负数
     *
     * @param score 分值/负数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}