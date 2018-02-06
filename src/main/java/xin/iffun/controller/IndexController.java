package xin.iffun.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.iffun.service.WeixinUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/23
 * Time: 18:10
 */
@RequestMapping("/")
@Controller
public class IndexController {


    private Logger _log = LoggerFactory.getLogger(IndexController.class);


    @Resource
    private WeixinUserService weixinUserService;





    @RequestMapping("/MP_verify_{randomCode}.txt")
    public void auth2(@PathVariable String randomCode, HttpServletResponse response) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("MP_verify_" + randomCode+".txt");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename="+randomCode+".txt");
        response.setCharacterEncoding("utf-8");
        IOUtils.copy(is,response.getOutputStream());
    }


    @RequestMapping("/weixin/MP_verify_{randomCode}.txt")
    public void auth(@PathVariable String randomCode, HttpServletResponse response) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("MP_verify_" + randomCode+".txt");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename="+randomCode+".txt");
        response.setCharacterEncoding("utf-8");
        IOUtils.copy(is,response.getOutputStream());
    }






    @RequestMapping("/weixin/index")
    public String idnex(String code,String state,Model model){


        _log.info("code {}",code);

        if(StringUtils.isNotBlank(code)){
            Integer xx =weixinUserService.registerUser(code,state);
        }


        return "recyle/index";
    }




}
