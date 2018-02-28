package xin.iffun.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xin.iffun.entity.UserAuthLog;
import xin.iffun.entity.UserInfo;
import xin.iffun.mapper.UserAuthLogMapper;
import xin.iffun.mapper.UserInfoMapper;
import xin.iffun.service.WeixinUserService;
import xin.iffun.util.HttpClientUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
    public UserInfo registerUser(String code, String state) {

        _log.info("CODE:{},state:{}",code,state);

        String s = userAccessToken.replaceAll("APPID", appid).replaceAll("SECRET", secret).replaceAll("CODE", code);
        //        https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        JSONObject object = HttpClientUtils.httpGet(s);
        if (!object.containsKey("errcode")){

            _log.info("access_token 返回值：{}",object.toString());
//        { "access_token":"ACCESS_TOKEN",
//                "expires_in":7200,
//                "refresh_token":"REFRESH_TOKEN",
//                "openid":"OPENID",
//                "scope":"SCOPE" }


            String openid = object.getString("openid");
            Example example = new Example(UserAuthLog.class);
            example.createCriteria().andEqualTo("openid",openid);
            List<UserAuthLog> userAuthLogs = userAuthLogMapper.selectByExample(example);

            UserAuthLog log = null;

            if (userAuthLogs == null || userAuthLogs.size() == 0){
                log = new UserAuthLog();
                log.setAccessToken(object.getString("access_token"));

                log.setCode(code);

                log.setCreatetime(new Date());
                log.setUpdatetime(new Date());
                log.setScope(object.getString("scope"));
                log.setExpiresIn(object.getLong("expires_in").intValue());
                log.setOpenid(object.getString("openid"));
                log.setRefreshToken(object.getString("refresh_token"));

                userAuthLogMapper.insertSelective(log);
            }else{
                log = userAuthLogs.get(0);
                log.setCode(code);
                log.setUpdatetime(new Date());
                userAuthLogMapper.updateByPrimaryKeySelective(log);
            }

            UserInfo info = getUserInfo(log.getOpenid(),log.getAccessToken());
            return info;
        }

        _log.info("code码 错误：{}",object.toString());
        return null;
    }



    @Override
    public UserInfo getUserInfo(String openid,String accessToken){
        UserInfo result = null;

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("openid",openid);
        List<UserInfo> list = userInfoMapper.selectByExample(example);

        if (list == null || list.size() == 0 ){

            String s1 = getUserInfoUrl.replaceAll("OPENID", openid).replaceAll("ACCESS_TOKEN", accessToken);

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
            String o = array.size()>0?(String) array.stream().reduce((p1, p2) -> p1.toString() + "," + p2.toString()).get():"[]";
            info.setPrivilege(o);

            Integer x = userInfoMapper.insertSelective(info);
            if (x > 0 ){
                result = info;
            }
        }else{
            if (list!=null&&list.size()>0){
                result = list.get(0);
            }
        }
        return  result;
    }

    @Override
    public UserAuthLog isLogin(String code) {
//        Boolean fo = false;
        UserAuthLog authLog = null;
        if (StringUtils.isNotBlank(code)){
            Example example = new Example(UserAuthLog.class);
            example.createCriteria().andEqualTo("code",code);
            List<UserAuthLog> logs = userAuthLogMapper.selectByExample(example);
            if (logs!=null && logs.size()> 0){
                Date date = logs.get(0).getUpdatetime();
                if (System.currentTimeMillis() - date.getTime() < 1000 * 60 * 60 * 24){
//                    fo = true;
                   authLog = logs.get(0);
                }
            }
        }
        return authLog;
    }

    @Override
    public UserInfo selectUserInfoByOpenId(String openid) {
        List<UserInfo> userInfos = null;
        if (StringUtils.isNotBlank(openid)){
            Example example = new Example(UserInfo.class);
            example.createCriteria().andEqualTo(openid);
            userInfos = userInfoMapper.selectByExample(example);
        }
        return userInfos!=null && userInfos.size()>0?userInfos.get(0):null;
    }

}
