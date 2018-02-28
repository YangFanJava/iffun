package xin.iffun.service;

import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.vo.RecyleOrderVo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/12
 * Time: 18:02
 */
public interface RecyleOrderService {
    Integer createRecyleOrder(RecyleOrder order);

    RecyleOrderVo selectOrderList(Integer oid);

    List<RecyleOrderVo> selectOrderListByUid(Integer uid);

    List<Map<String,Object>> selectCountDataByUId(Integer id);
}
