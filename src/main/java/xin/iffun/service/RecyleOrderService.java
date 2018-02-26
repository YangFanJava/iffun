package xin.iffun.service;

import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.vo.RecyleOrderVo;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/12
 * Time: 18:02
 */
public interface RecyleOrderService {
    Integer createRecyleOrder(RecyleOrder order);

    RecyleOrderVo selectOrderList(Integer oid);

}
