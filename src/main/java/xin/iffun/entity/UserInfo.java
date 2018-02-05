package xin.iffun.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户昵称
     */
    private String openid;

    /**
     * 用户唯一标识
     */
    private String nickname;

    /**
     * 	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private String sex;

    /**
     * 用户个人资料填写的省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private String headimgurl;

    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    private String privilege;

    /**
     * 	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String unionid;

    /**
     * 更新时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取用户昵称
     *
     * @return openid - 用户昵称
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户昵称
     *
     * @param openid 用户昵称
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取用户唯一标识
     *
     * @return nickname - 用户唯一标识
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户唯一标识
     *
     * @param nickname 用户唯一标识
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @return sex - 	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @param sex 	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取用户个人资料填写的省份
     *
     * @return province - 用户个人资料填写的省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置用户个人资料填写的省份
     *
     * @param province 用户个人资料填写的省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取普通用户个人资料填写的城市
     *
     * @return city - 普通用户个人资料填写的城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置普通用户个人资料填写的城市
     *
     * @param city 普通用户个人资料填写的城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取国家，如中国为CN
     *
     * @return country - 国家，如中国为CN
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家，如中国为CN
     *
     * @param country 国家，如中国为CN
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     *
     * @return headimgurl - 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     *
     * @param headimgurl 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     *
     * @return privilege - 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * 设置用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     *
     * @param privilege 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    /**
     * 获取	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @return unionid - 	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @param unionid 	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取更新时间
     *
     * @return create_time - 更新时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置更新时间
     *
     * @param createTime 更新时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}