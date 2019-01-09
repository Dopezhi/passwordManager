package com.pwd.pojo;

public class Password {
    private Integer id;

    private Integer pwdLoginid;

    private String pwdName;

    private String pwdDescribe;

    private String pwdAccount;

    private String pwdUrl;

    private Integer pwdType;

    private String pwdPassword;

    public Password(Integer id, Integer pwdLoginid, String pwdName, String pwdDescribe, String pwdAccount, String pwdUrl, Integer pwdType, String pwdPassword) {
        this.id = id;
        this.pwdLoginid = pwdLoginid;
        this.pwdName = pwdName;
        this.pwdDescribe = pwdDescribe;
        this.pwdAccount = pwdAccount;
        this.pwdUrl = pwdUrl;
        this.pwdType = pwdType;
        this.pwdPassword = pwdPassword;
    }

    public Password() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPwdLoginid() {
        return pwdLoginid;
    }

    public void setPwdLoginid(Integer pwdLoginid) {
        this.pwdLoginid = pwdLoginid;
    }

    public String getPwdName() {
        return pwdName;
    }

    public void setPwdName(String pwdName) {
        this.pwdName = pwdName == null ? null : pwdName.trim();
    }

    public String getPwdDescribe() {
        return pwdDescribe;
    }

    public void setPwdDescribe(String pwdDescribe) {
        this.pwdDescribe = pwdDescribe == null ? null : pwdDescribe.trim();
    }

    public String getPwdAccount() {
        return pwdAccount;
    }

    public void setPwdAccount(String pwdAccount) {
        this.pwdAccount = pwdAccount == null ? null : pwdAccount.trim();
    }

    public String getPwdUrl() {
        return pwdUrl;
    }

    public void setPwdUrl(String pwdUrl) {
        this.pwdUrl = pwdUrl == null ? null : pwdUrl.trim();
    }

    public Integer getPwdType() {
        return pwdType;
    }

    public void setPwdType(Integer pwdType) {
        this.pwdType = pwdType;
    }

    public String getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(String pwdPassword) {
        this.pwdPassword = pwdPassword == null ? null : pwdPassword.trim();
    }
}