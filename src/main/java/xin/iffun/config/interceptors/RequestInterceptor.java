package xin.iffun.config.interceptors;/**
 * Created by Easong on 2017/11/30.
 */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试拦截器
 *
 * @author Easong
 * @create 2017-11-30 11:49
 **/
public class RequestInterceptor implements HandlerInterceptor{

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
        return true;
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
