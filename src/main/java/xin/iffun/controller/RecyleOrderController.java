package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.UserInfo;
import xin.iffun.entity.vo.QAVo;
import xin.iffun.entity.vo.RecyleOrderVo;
import xin.iffun.service.PhoneService;
import xin.iffun.service.RecyleOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/24
 * Time: 16:31
 */
@RequestMapping("/weixin/order")
@Controller
public class RecyleOrderController {


    @Resource
    private RecyleOrderService recyleOrderService;


    @Resource
    private PhoneService phoneService;



    @RequestMapping("/toList")
    public String goOrderList(HttpServletRequest request,Model model) {
        UserInfo info =(UserInfo) request.getAttribute("userInfo");
        if (info != null && info.getId() != null){
            List<RecyleOrderVo>  orders = recyleOrderService.selectOrderListByUid(info.getId());
            model.addAttribute("orders",orders);
        }
        return "recyle/orderList";
    }

    @RequestMapping("/toInfo")
    public String goOrderList(Integer oid,HttpServletRequest request,Model model) {
//        UserInfo info =(UserInfo) request.getAttribute("userInfo");
        RecyleOrderVo recyleOrder = recyleOrderService.selectOrderList(oid);

        List<QAVo> vos = phoneService.searchQaByProductId(recyleOrder.getProduct().getId());

        Map<String, QAVo.Answer> answers  =  null;

        if (vos != null && vos.size() > 0 ){
            answers = vos.stream().map(p -> p.getAnswers()).reduce((p1, p2) -> {
                p1.addAll(p2);
                return p1;
            }).get().stream().collect(Collectors.toMap(p->p.getId()+"", p -> p));
        }

        model.addAttribute("answers",answers);
        model.addAttribute("info",recyleOrder);
        model.addAttribute("defaultImage","http://img11.360buyimg.com/n2/jfs/t12730/306/1517709913/155178/f5e7e927/5a22acfaNf7222715.jpg!q95.jpg");

        return "recyle/orderInfo";
    }




}
