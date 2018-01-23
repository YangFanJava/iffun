package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "access_qa")
public class AccessQa {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * 问题排序
     */
    @Column(name = "q_sort")
    private String qSort;

    /**
     * 答案排序
     */
    @Column(name = "a_sort")
    private Integer aSort;

    /**
     * 是否多选
     */
    @Column(name = "is_multi")
    private Integer isMulti;

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
     * 获取问题
     *
     * @return question - 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问题
     *
     * @param question 问题
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 获取答案
     *
     * @return answer - 答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置答案
     *
     * @param answer 答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取问题排序
     *
     * @return q_sort - 问题排序
     */
    public String getqSort() {
        return qSort;
    }

    /**
     * 设置问题排序
     *
     * @param qSort 问题排序
     */
    public void setqSort(String qSort) {
        this.qSort = qSort;
    }

    /**
     * 获取答案排序
     *
     * @return a_sort - 答案排序
     */
    public Integer getaSort() {
        return aSort;
    }

    /**
     * 设置答案排序
     *
     * @param aSort 答案排序
     */
    public void setaSort(Integer aSort) {
        this.aSort = aSort;
    }

    /**
     * 获取是否多选
     *
     * @return is_multi - 是否多选
     */
    public Integer getIsMulti() {
        return isMulti;
    }

    /**
     * 设置是否多选
     *
     * @param isMulti 是否多选
     */
    public void setIsMulti(Integer isMulti) {
        this.isMulti = isMulti;
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