package xin.iffun.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * Description: 继承自己的CommonMapper
 * 特别注意，该接口不能被扫描到，否则会出错
 *
 * @author Easong
 * @version 2017/12/5
 * @param 
 * @since JDK1.7
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
