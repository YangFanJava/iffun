package xin.iffun.config.fileupload;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @Author:Easong
 * @Description:springboot里默认使用tomcat的上传文件大小限制，即1MB,修改配置
 * @Date:Created in 23:12 2017/7/16
 * Modified By:
 */
@Configuration
public class MultipartConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("4096MB");
        // 设置总上传数据总大小
        factory.setMaxRequestSize("12288MB");
        return factory.createMultipartConfig();
    }
}
