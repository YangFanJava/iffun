package xin.iffun.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/31
 * Time: 17:15
 */
public class QAVo  implements Serializable{

    private Integer id;

    private String questionInfo;

    private Integer sort;

    private Integer isMulti;

    private List<Answer> answers;


    public QAVo() {
    }

    public class Answer{

        private Integer id;
        private String answerInfo;

        private Integer sort;

        private Integer score;

        public Answer() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAnswerInfo() {
            return answerInfo;
        }

        public void setAnswerInfo(String answerInfo) {
            this.answerInfo = answerInfo;
        }

        public Integer getSort() {
            return sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionInfo() {
        return questionInfo;
    }

    public void setQuestionInfo(String questionInfo) {
        this.questionInfo = questionInfo;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(Integer isMulti) {
        this.isMulti = isMulti;
    }
}
