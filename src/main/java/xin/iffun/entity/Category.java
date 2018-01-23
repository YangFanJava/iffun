package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

public class Category {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类名称  手机  平板 笔记本
     */
    private String name;

    /**
     * 所属行业
     */
    private String trade;

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
     * 获取分类名称  手机  平板 笔记本
     *
     * @return name - 分类名称  手机  平板 笔记本
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称  手机  平板 笔记本
     *
     * @param name 分类名称  手机  平板 笔记本
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取所属行业
     *
     * @return trade - 所属行业
     */
    public String getTrade() {
        return trade;
    }

    /**
     * 设置所属行业
     *
     * @param trade 所属行业
     */
    public void setTrade(String trade) {
        this.trade = trade;
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