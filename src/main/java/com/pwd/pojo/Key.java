package com.pwd.pojo;

public class Key {
    private Integer id;

    private String keyLoginid;

    private String keyContent;

    public Key(Integer id, String keyLoginid, String keyContent) {
        this.id = id;
        this.keyLoginid = keyLoginid;
        this.keyContent = keyContent;
    }

    public Key() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyLoginid() {
        return keyLoginid;
    }

    public void setKeyLoginid(String keyLoginid) {
        this.keyLoginid = keyLoginid == null ? null : keyLoginid.trim();
    }

    public String getKeyContent() {
        return keyContent;
    }

    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent == null ? null : keyContent.trim();
    }
}