package xin.iffun.config.interceptors;/**
 * Created by Easong on 2017/11/30.
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xin.iffun.entity.UserAuthLog;
import xin.iffun.entity.UserInfo;
import xin.iffun.service.WeixinUserService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试拦截器
 *
 * @author Easong
 * @create 2017-11-30 11:49
 **/
@Component
public class RequestInterceptor implements HandlerInterceptor{


    @Resource
    private WeixinUserService weixinUserService;




    /**
     *
     * Description:请求发生前执行
     *
     * @author Easong
     * @version 2017/11/30
     * @param  request, response, handler]
     * @since JDK1.7
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

//        UserInfo info = weixinUserService.selectUserInfoByOpenId("ouh3f1JEUBUPQoNaaoiYIwpIim7E");
//        request.setAttribute("userInfo",info);
//
//        return  true;

//     if (request.getRequestURI().contains())

//
 //      请求拦截  判断是否登陆

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie:cookies) {
                if("token".equals(cookie.getName())){
                    String code = cookie.getValue();
                    UserAuthLog userLog = weixinUserService.isLogin(code);
                    if (userLog!=null){
                        //固定几个接口需要放置userInfo对象
                        if (request.getRequestURI().contains("/weixin/recyle/createOrder")
                                ||request.getRequestURI().contains("/weixin/user/index")
                                ||request.getRequestURI().contains("/weixin/order/toList")){
                            UserInfo info = weixinUserService.selectUserInfoByOpenId(userLog.getOpenid());
                            request.setAttribute("userInfo",info);
                        }
                        return true;
                    }
                }
            }
        }

        String code = request.getParameter("code");
        if (StringUtils.isNotBlank(code)){
            UserInfo userinfi = weixinUserService.registerUser(code, null);
            if (userinfi!=null){
                Cookie cookie = new Cookie("token",code);
                response.addCookie(cookie);
                request.setAttribute("userInfo",userinfi);
                return true;
            }
        }

        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setStatus(200);
        response.getWriter().write("No permission error　！！");
        return false;
    }

    /**
     *
     * Description:
     *
     * @author Easong
     * @version 2017/11/30
     * @param  request, response, handler, modelAndView]
     * @since JDK1.7
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.err.println("本次请求时间为：" + (endTime - startTime));
        request.setAttribute("requestTime", endTime - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
