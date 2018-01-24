package xin.iffun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.service.TestService;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/23
 * Time: 18:10
 */
@RequestMapping("/weixin")
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String idnex(Model model){
        model.addAttribute("test1","hello word1!!"+ new Random().nextInt(100));
        return "recyle/index";
    }


    @Resource
    private TestService testService;



    @RequestMapping("/test")
    public String test(Model model){

        testService.test();


        return "recyle/index";
//        return "test/test";
    }



}
