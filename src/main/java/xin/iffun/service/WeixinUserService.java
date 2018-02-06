package xin.iffun.service;

import xin.iffun.entity.UserAuthLog;

/**
 * Created with IntelliJ IDEA
 * Created By YangF
 * Date: 2018/2/5
 * Time: 17:58
 */
public interface WeixinUserService {
    UserAuthLog registerUser(String code, String state);

    Integer getUserInfo(String openid,String accessToken);

    Boolean isLogin(String code);
}
