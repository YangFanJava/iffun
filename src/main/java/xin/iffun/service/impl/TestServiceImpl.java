package xin.iffun.service.impl;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xin.iffun.entity.AccessQa;
import xin.iffun.mapper.AccessQaMapper;
import xin.iffun.service.TestService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    @Resource
    private AccessQaMapper accessQaMapper;



    @Override
    public void test() {

        Example accessQaExample = new Example(AccessQa.class);
        accessQaExample.createCriteria().andEqualTo("aSort",121);
        List<AccessQa> qas = accessQaMapper.selectAll();
        List<AccessQa> accessQas = accessQaMapper.selectByExample(accessQaExample);


        System.out.println("");
    }
}
