package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.entity.vo.QAVo;
import xin.iffun.service.PhoneService;

import javax.annotation.Resource;
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


    /**
     * 准备数据
     *
     * @param priceId
     * @return
     */
    @RequestMapping("/estimate")
    public String goEstimatePage(String priceId, Model model){
        ProductVo vo  = phoneService.selectPhoneByPriceId(priceId);


        List<QAVo> qaVo = phoneService.searchQaByProductId(vo.getId());

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
        model.addAttribute("qaIds",vo);
        model.addAttribute("estimatePrice",new BigDecimal(recoverPrice).subtract(new BigDecimal(score)));

        return "recyle/order";
    }




}
