package xin.iffun.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xin.iffun.entity.vo.ProductVo;
import xin.iffun.mapper.ProductMapper;
import xin.iffun.mapper.ProductPriceMapper;
import xin.iffun.service.PhoneService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/1/24
 * Time: 17:42
 */
@Service
public class PhoneServiceImpl implements PhoneService {


    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductPriceMapper productPriceMapper;


    @Override
    public List<ProductVo> selectList(String keyword, int page, int limit) {

        PageHelper.startPage(page,limit,false);
        return productPriceMapper.selectBYkeyWord(keyword);
    }
}
