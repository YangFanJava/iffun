package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.entity.RecyleOrder;
import xin.iffun.entity.UserInfo;
import xin.iffun.service.RecyleOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/23
 * Time: 15:03
 */
@RequestMapping("/weixin/user")
@Controller
public class UserController {



    @Resource
    private RecyleOrderService recyleOrderService;



    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model){
        UserInfo info = (UserInfo) request.getAttribute("userInfo");

//        recyleOrderService.selectOrderByUid(info.getId());
        model.addAttribute("info",info);

        return "user/index";
    }


}
