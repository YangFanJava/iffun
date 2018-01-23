package xin.iffun.aspect;

import java.lang.annotation.*;

/**
 *
 * Description: 日志注解
 *
 * @author Easong
 * @version 2017/12/5
 * @param
 * @since JDK1.7
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

    public String description();
}
