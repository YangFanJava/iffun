package xin.iffun.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xin.iffun.entity.UserAuthLog;
import xin.iffun.entity.UserInfo;
import xin.iffun.mapper.UserAuthLogMapper;
import xin.iffun.mapper.UserInfoMapper;
import xin.iffun.service.WeixinUserService;
import xin.iffun.util.HttpClientUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/5
 * Time: 18:02
 */
@Service
public class WeixinUserServiceImpl implements WeixinUserService {


    @Value("${weixin.userAccessToken}")
    private String userAccessToken;

    @Value("${weixin.getUserInfoUrl}")
    private String getUserInfoUrl;

    @Value("${weixin.appid}")
    private String appid;

    @Value("${weixin.secret}")
    private String secret;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserAuthLogMapper userAuthLogMapper;


    private Logger _log = LoggerFactory.getLogger(WeixinUserServiceImpl.class);


    @Override
    public Integer registerUser(String code, String state) {

        _log.info("CODE:{},state:{}",code,state);
        String s = userAccessToken.replaceAll("APPID", appid).replaceAll("SECRET", secret).replaceAll("CODE", code);
        //        https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        JSONObject object = HttpClientUtils.httpGet(s);


        _log.info("access_token 返回值：{}",object.toString());
//        { "access_token":"ACCESS_TOKEN",
//                "expires_in":7200,
//                "refresh_token":"REFRESH_TOKEN",
//                "openid":"OPENID",
//                "scope":"SCOPE" }
        UserAuthLog log = new UserAuthLog();
        log.setAccessToken(object.getString("access_token"));
        log.setCreatetime(new Date());
        log.setScope(object.getString("scope"));
        log.setExpiresIn(object.getLong("expires_in").intValue());
        log.setOpenid(object.getString("openid"));
        log.setRefreshToken(object.getString("refresh_token"));

        int i = userAuthLogMapper.insert(log);

        _log.info("存储 日志成功数：{}",i);

        String s1 = getUserInfoUrl.replaceAll("OPENID", log.getOpenid()).replaceAll("ACCESS_TOKEN", log.getAccessToken());

        JSONObject userInfoObject = HttpClientUtils.httpGet(s1);

        _log.info("用户详情返回值:{}",userInfoObject.toString());

        UserInfo info = new UserInfo();
        info.setOpenid(userInfoObject.getString("openid"));
        info.setNickname(userInfoObject.getString("nickname"));
        info.setSex(userInfoObject.getString("sex"));
        info.setProvince(userInfoObject.getString("province"));
        info.setCity(userInfoObject.getString("city"));
        info.setCountry(userInfoObject.getString("country"));
        info.setHeadimgurl(userInfoObject.getString("headimgurl"));
        info.setUnionid(userInfoObject.getString("unionid"));
        info.setCreateTime(new Date());
        JSONArray array = userInfoObject.getJSONArray("privilege");
        String o = (String) array.stream().reduce((p1, p2) -> p1.toString() + "," + p2.toString()).get();
        info.setPrivilege(o);

        int insert = userInfoMapper.insert(info);

        _log.info("用户详情存储状态:{}",insert);
        return insert;
    }


}
