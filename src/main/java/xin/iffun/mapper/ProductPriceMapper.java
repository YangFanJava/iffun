package xin.iffun.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.provider.ExampleProvider;
import xin.iffun.entity.ProductPrice;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.util.CommonMapper;

import java.util.List;

public interface ProductPriceMapper extends CommonMapper<ProductPrice> {
    List<ProductVo> selectBYkeyWord(String keyword);

    List<ProductVo> selectVoByExample(@Param("criteria") String criteria);

    ProductVo selectPhoneByPriceId(@Param("priceId") String priceId);
}