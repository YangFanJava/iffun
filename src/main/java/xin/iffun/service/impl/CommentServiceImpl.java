package xin.iffun.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xin.iffun.entity.OrderComment;
import xin.iffun.mapper.OrderCommentMapper;
import xin.iffun.service.CommentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/24
 * Time: 14:56
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Resource
    private OrderCommentMapper orderCommentMapper ;


    @Override
    public List<OrderComment> selectShowComment(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return orderCommentMapper.selectAll();
    }
}
