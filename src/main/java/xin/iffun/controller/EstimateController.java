package xin.iffun.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.UserAuthLog;
import xin.iffun.entity.UserInfo;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.entity.vo.QAVo;
import xin.iffun.service.PhoneService;
import xin.iffun.service.RecyleOrderService;
import xin.iffun.util.DateUtils;
import xin.iffun.util.R;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/31
 * Time: 16:51
 */
@Controller
@RequestMapping("/weixin/recyle")
public class EstimateController {


    @Resource
    private  PhoneService phoneService;

    @Resource
    private RecyleOrderService recyleOrderService;


    /**
     * 准备数据
     *
     * @param priceId
     * @return
     */
    @RequestMapping("/estimate")
    public String goEstimatePage(String priceId,String qaIds,Model model){
        ProductVo vo  = phoneService.selectPhoneByPriceId(priceId);


        List<QAVo> qaVo = phoneService.searchQaByProductId(vo.getId());

        if (StringUtils.isNotBlank(qaIds)){
            String[] qaIdsArray = qaIds.split(",");
            model.addAttribute("qaIds",qaIdsArray);
        }
        model.addAttribute("product",vo);
        model.addAttribute("qaVo",qaVo);
        return "recyle/qa";
    }



    /**
     * 评估结束 查看结果
     *
     * @param priceId
     * @return
     */
    @RequestMapping("/order")
    public String goOrderPage(@RequestParam String priceId,
                              @RequestParam String qaIds,
                              @RequestParam String recoverPrice,
                              @RequestParam String  score, Model model){

        ProductVo vo  = phoneService.selectPhoneByPriceId(priceId);


        model.addAttribute("product",vo);
        model.addAttribute("priceId",priceId);
        model.addAttribute("qaIds",qaIds);
        model.addAttribute("estimatePrice",new BigDecimal(recoverPrice).subtract(new BigDecimal(score)));

        return "recyle/order";
    }



    /**
     * 订单创建 查看结果
     *
     * @param priceId
     * @return
     */
    @RequestMapping("/createOrder")
    @ResponseBody
    public R createOrder(@RequestParam String priceId,
                         @RequestParam String recyleType,
                         @RequestParam String qaUser,
                         @RequestParam String estimatePriceUser,
                         @RequestParam String userName,
                         @RequestParam String userPhone,
                         HttpServletRequest request,
                         //  快递单号
                         String expressCode,
                         //预约时间
                         String appointmentTimeStr,
                         String appointmentAddress,
                         Model model){
        if (StringUtils.isBlank(userName)||StringUtils.isBlank(userPhone)){

            return R.error("");
        }
        RecyleOrder order = new RecyleOrder();
        switch (recyleType){

            //上门回收  预约时间
            case "0":
                if (StringUtils.isBlank(appointmentAddress)){
                    return R.error("");
                }
                order.setAppointmentAddress(appointmentAddress);
                //穿透 向下判断时间
            //到店回收
            case "1":
                if (StringUtils.isBlank(appointmentTimeStr)){
                    return R.error("");
                }
                order.setAppointmentTime(DateUtils.stringToDate(appointmentTimeStr,"yyyy-MM-dd HH:mm:ss"));
                break;
            //快递回收
            case "2":
                order.setExpressCode(expressCode);
//                if (StringUtils.isBlank(expressCode)){
//                    return "";
//                }
                break;
            default:      return R.error("");
        }

        //uid
        UserInfo info = (UserInfo) request.getAttribute("userInfo");

        if ( info==null ){
            return R.error();
        }
        order.setUid(info.getId());

        Integer i = recyleOrderService.createRecyleOrder(order);
        return R.ok(i+"");
    }



}
