package xin.iffun.util;

import java.util.UUID;

/**
 *
 * Description: 生成随机字符串工具类
 *
 * @author Easong
 * @version 2017/12/13
 * @param
 * @since JDK1.7
 */
public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
