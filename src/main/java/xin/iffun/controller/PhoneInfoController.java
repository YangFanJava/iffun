package xin.iffun.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.entity.Product;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.service.PhoneService;
import xin.iffun.util.R;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/24
 * Time: 17:31
 */
@RequestMapping("/weixin/phone")
@Controller
public class PhoneInfoController {

    @Resource
    private PhoneService phoneService;




    @RequestMapping("/byName")
    public R selectPhoneList(String keyword){
        List<ProductVo> vos = null;
        if (StringUtils.isNotBlank(keyword)){
            vos = phoneService.selectList(keyword,1,10);
        }else{
            vos = phoneService.selectHotList(1,10);
        }
        return R.ok();
    }




}
