package xin.iffun.service;

import xin.iffun.entity.vo.ProductVo;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/24
 * Time: 17:36
 */
public interface PhoneService {
    List<ProductVo> selectList(String keyword, int page, int limit);

    List<ProductVo> selectHotList(int i, int i1);

}
