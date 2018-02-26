package xin.iffun.mapper;

import org.apache.ibatis.annotations.Param;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.vo.RecyleOrderVo;
import xin.iffun.util.CommonMapper;

public interface RecyleOrderMapper extends CommonMapper<RecyleOrder> {
    RecyleOrderVo selectOrderInfo(@Param("oid") Integer oid);
}