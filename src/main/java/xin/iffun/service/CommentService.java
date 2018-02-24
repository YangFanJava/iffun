package xin.iffun.service;

import xin.iffun.entity.OrderComment;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/24
 * Time: 14:52
 */
public interface CommentService {


    List<OrderComment> selectShowComment(int page, int pageSize);

}
