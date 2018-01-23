package xin.iffun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
// 装载Mybatis MapperProperties配置
//@EnableConfigurationProperties(value = {MapperProperties.class})
@ComponentScan(basePackages = "xin.iffun.*") // 开启通用注解扫描
//@MapperScan(basePackages = "cn.jdcg.dao")
@ServletComponentScan // 扫描使用注解方式的servlet
@EnableTransactionManagement
//@EnableAutoConfiguration(exclude = MultipartAutoConfiguration.class)
public class IffunApplication {

    public static void main(String[] args) {
        SpringApplication.run(IffunApplication.class, args);
    }
}
