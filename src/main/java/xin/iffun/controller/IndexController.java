package xin.iffun.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/23
 * Time: 18:10
 */
@RequestMapping("/weixin")
public class IndexController {


    @RequestMapping("/index")
    public String idnex(){
        return "recyle/index.html";
    }



}
