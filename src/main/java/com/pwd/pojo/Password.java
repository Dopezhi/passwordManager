package com.pwd.pojo;

public class Password {
    private Integer id;

    private Integer pwdloginid;

    private String pwdname;

    private String pwdcontent;

    private String pwdkey;

    private String pwdurl;

    private String pwdtype;

    public Password(Integer id, Integer pwdloginid, String pwdname, String pwdcontent, String pwdkey, String pwdurl, String pwdtype) {
        this.id = id;
        this.pwdloginid = pwdloginid;
        this.pwdname = pwdname;
        this.pwdcontent = pwdcontent;
        this.pwdkey = pwdkey;
        this.pwdurl = pwdurl;
        this.pwdtype = pwdtype;
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

    public Integer getPwdloginid() {
        return pwdloginid;
    }

    public void setPwdloginid(Integer pwdloginid) {
        this.pwdloginid = pwdloginid;
    }

    public String getPwdname() {
        return pwdname;
    }

    public void setPwdname(String pwdname) {
        this.pwdname = pwdname == null ? null : pwdname.trim();
    }

    public String getPwdcontent() {
        return pwdcontent;
    }

    public void setPwdcontent(String pwdcontent) {
        this.pwdcontent = pwdcontent == null ? null : pwdcontent.trim();
    }

    public String getPwdkey() {
        return pwdkey;
    }

    public void setPwdkey(String pwdkey) {
        this.pwdkey = pwdkey == null ? null : pwdkey.trim();
    }

    public String getPwdurl() {
        return pwdurl;
    }

    public void setPwdurl(String pwdurl) {
        this.pwdurl = pwdurl == null ? null : pwdurl.trim();
    }

    public String getPwdtype() {
        return pwdtype;
    }

    public void setPwdtype(String pwdtype) {
        this.pwdtype = pwdtype == null ? null : pwdtype.trim();
    }
}