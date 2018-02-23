package xin.iffun.service.impl;

import org.springframework.stereotype.Service;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.mapper.RecyleOrderMapper;
import xin.iffun.service.RecyleOrderService;

import javax.annotation.Resource;
import java.util.Date;

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
}
