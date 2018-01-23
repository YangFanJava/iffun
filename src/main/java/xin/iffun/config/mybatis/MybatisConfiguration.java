package xin.iffun.config.mybatis;/**
 * Created by Easong on 2017/7/17.
 */
/**
 * MyBatis配置
 *
 * @author Easong
 * @create 2017-07-17 13:35
 **/
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

//@Configuration
//@EnableTransactionManagement
public class MybatisConfiguration implements TransactionManagementConfigurer{

    private static Log logger = LogFactory.getLog(MybatisConfiguration.class);

    //  配置类型别名
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    //  配置mapper的扫描，找到所有的mapper.xml映射文件
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    //  加载全局的配置文件
    /*@Value("${mybatis.configLocation}")
    private String configLocation;*/

    @Autowired
    private DataSource dataSource;
    // DataSource配置
    //  @Bean
    //  @ConfigurationProperties(prefix = "spring.datasource")
    //  public DruidDataSource dataSource() {
    //      return new com.alibaba.druid.pool.DruidDataSource();
    //  }

    // 提供SqlSeesion
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);

            // 读取配置
            sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources(mapperLocations);
            sessionFactoryBean.setMapperLocations(resources);
           /* sessionFactoryBean.setConfigLocation(
                    new DefaultResourceLoader().getResource(configLocation));*/


            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("/***************** mybatis resolver mapper*xml is error **************/");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("/***************** mybatis sqlSessionFactoryBean create error **************/");
            return null;
        }
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
