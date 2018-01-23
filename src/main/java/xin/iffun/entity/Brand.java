package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

public class Brand {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称  华为 苹果
     */
    private String name;

    /**
     * 是否使用  默认使用
     */
    @Column(name = "is_use")
    private Integer isUse;

    /**
     * 优先级 排序控制
     */
    private Integer sort;

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
     * 获取名称  华为 苹果
     *
     * @return name - 名称  华为 苹果
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称  华为 苹果
     *
     * @param name 名称  华为 苹果
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否使用  默认使用
     *
     * @return is_use - 是否使用  默认使用
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置是否使用  默认使用
     *
     * @param isUse 是否使用  默认使用
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
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