package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_auth_log")
public class UserAuthLog {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * code
     */
    private String code;

    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 用户凭证 结合expires_in使用 生效时间为update_time
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    @Column(name = "expires_in")
    private Integer expiresIn;

    /**
     * 	用户刷新access_token
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息
     */
    private String scope;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取code
     *
     * @return code - code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取用户唯一标识
     *
     * @return openid - 用户唯一标识
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户唯一标识
     *
     * @param openid 用户唯一标识
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取用户凭证 结合expires_in使用 生效时间为update_time
     *
     * @return access_token - 用户凭证 结合expires_in使用 生效时间为update_time
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置用户凭证 结合expires_in使用 生效时间为update_time
     *
     * @param accessToken 用户凭证 结合expires_in使用 生效时间为update_time
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取access_token接口调用凭证超时时间，单位（秒）
     *
     * @return expires_in - access_token接口调用凭证超时时间，单位（秒）
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * 设置access_token接口调用凭证超时时间，单位（秒）
     *
     * @param expiresIn access_token接口调用凭证超时时间，单位（秒）
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * 获取	用户刷新access_token
     *
     * @return refresh_token - 	用户刷新access_token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 设置	用户刷新access_token
     *
     * @param refreshToken 	用户刷新access_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * 获取用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息
     *
     * @return scope - 用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息
     *
     * @param scope 用户授权的作用域，使用逗号（,）分隔  scope为 snsapi_userinfo时才可以拉取用户信息
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}