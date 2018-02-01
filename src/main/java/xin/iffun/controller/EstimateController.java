package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.entity.vo.QAVo;
import xin.iffun.service.PhoneService;

import javax.annotation.Resource;
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




}
