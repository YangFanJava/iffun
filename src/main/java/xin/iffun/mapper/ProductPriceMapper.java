package xin.iffun.mapper;

import xin.iffun.entity.ProductPrice;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.util.CommonMapper;

import java.util.List;

public interface ProductPriceMapper extends CommonMapper<ProductPrice> {
    List<ProductVo> selectBYkeyWord(String keyword);
}