package xin.iffun.mapper;

import org.apache.ibatis.annotations.Param;
import xin.iffun.entity.AccessQa;
import xin.iffun.entity.vo.QAVo;
import xin.iffun.util.CommonMapper;

import java.util.List;

public interface AccessQaMapper extends CommonMapper<AccessQa> {
    List<QAVo> searchQaByProductId(@Param("productId") Integer productId);
}