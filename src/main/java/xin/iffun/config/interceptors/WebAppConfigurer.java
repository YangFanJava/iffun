package xin.iffun.config.interceptors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:Easong
 * @Description:拦截器配置
 * @Date:Created in 23:21 2017/7/16
 * Modified By:
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor();
    }
    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截

        // registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(requestInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @deprecated: 添加自定义的静态资源映射
         *                这里使用代码的方式自定义目录映射，
         *                并不影响Spring Boot的默认映射，可以同时使用。
         *                springboot默认不拦截的静态资源
         *                classpath:/META-INF/resources
         *                classpath:/resources
         *                classpath:/static
         *                classpath:/public
         *
         * @Author:Easong
         * @Date:Created in 2017/7/16
         * @param: [registry]
         * @return: void
         *
         */

        //      registry.addResourceHandler("/new/**").addResourceLocations("classpath:/new/");
        //      registry.addResourceHandler("/**").addResourceLocations("/");
        super.addResourceHandlers(registry);
    }

    /**
     *
     * Description:统一管理Controller层无业务只是页面跳转
     *
     * @author Easong
     * @version 2017/11/30
     * @param  registry ]
     * @since JDK1.7
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index/index");
    }
}
