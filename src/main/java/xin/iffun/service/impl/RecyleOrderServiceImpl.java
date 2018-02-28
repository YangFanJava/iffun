package xin.iffun.service.impl;

import org.springframework.stereotype.Service;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.vo.RecyleOrderVo;
import xin.iffun.mapper.RecyleOrderMapper;
import xin.iffun.service.RecyleOrderService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/12
 * Time: 18:03
 */
@Service
public class RecyleOrderServiceImpl implements RecyleOrderService {



    @Resource
    private RecyleOrderMapper recyleOrderMapper;


    /**
     * 保存订单
     * @param order
     * @return
     */
    @Override
    public Integer createRecyleOrder(RecyleOrder order) {

        //填充订单信息
        Date curDate = new Date();
        order.setCreateTime(curDate);
        order.setUpdateTime(curDate);
        //回收状态使用默认值
        order.setRecyleState("0");
        //支付状态使用默认值
        order.setPayState("0");

        return recyleOrderMapper.insertSelective(order);
    }

    @Override
    public RecyleOrderVo selectOrderList(Integer oid) {
        List<RecyleOrderVo> vos = recyleOrderMapper.selectOrderInfo(oid, null);
        return vos!=null && vos.size()>0 ?vos.get(0):null;
    }

    @Override
    public List<RecyleOrderVo> selectOrderListByUid(Integer uid) {
        return recyleOrderMapper.selectOrderInfo(null,uid);
    }

    @Override
    public List<Map<String, Object>> selectCountDataByUId(Integer uid) {


        return recyleOrderMapper.selectCountDataByUId(uid);
    }
}
