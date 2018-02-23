package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/23
 * Time: 15:03
 */
@RequestMapping("/weixin/user")
@Controller
public class UserController {


    @RequestMapping("/index")
    public String index(Model model){
        return "user/index";
    }






}
