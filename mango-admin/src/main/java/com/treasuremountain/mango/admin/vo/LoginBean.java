package com.treasuremountain.mango.admin.vo;

/**
 * 登录接口封装对象
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2021/04/05 22:58
 */
public class LoginBean {

    private String account;
    private String password;
    private String captcha;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
