package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/24
 * Time: 16:31
 */
@RequestMapping("/weixin/order")
@Controller
public class RecyleOrderController {




    @RequestMapping("/toList")
    public String goOrderList(Model model) {
        return "recyle/orderList";
    }




}
