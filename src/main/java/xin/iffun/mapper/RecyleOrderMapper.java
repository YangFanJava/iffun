package xin.iffun.mapper;

import org.apache.ibatis.annotations.Param;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.vo.RecyleOrderVo;
import xin.iffun.util.CommonMapper;

import java.util.List;
import java.util.Map;

public interface RecyleOrderMapper extends CommonMapper<RecyleOrder> {
    List<RecyleOrderVo> selectOrderInfo(@Param("oid") Integer oid, @Param("uid") Integer uid);

    List<Map<String,Object>> selectCountDataByUId(@Param("uid") Integer uid);
}