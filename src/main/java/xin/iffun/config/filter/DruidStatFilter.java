package xin.iffun.config.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @Author:Easong
 * @Description:* 配置druid监控统计功能,配置Filter
 * @Date:Created in 23:15 2017/7/16
 * Modified By:
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
            @WebInitParam(name = "exclusions", value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        }, asyncSupported = true
)
public class DruidStatFilter extends WebStatFilter {

}
