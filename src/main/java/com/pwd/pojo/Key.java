package com.pwd.pojo;

public class Key {
    private Integer id;

    private Integer keyLoginid;

    private String keyContent;

    public Key(Integer id, Integer keyLoginid, String keyContent) {
        this.id = id;
        this.keyLoginid = keyLoginid;
        this.keyContent = keyContent;
    }

    public Key(Integer keyLoginid, String keyContent) {
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

    public Integer getKeyLoginid() {
        return keyLoginid;
    }

    public void setKeyLoginid(Integer keyLoginid) {
        this.keyLoginid = keyLoginid;
    }

    public String getKeyContent() {
        return keyContent;
    }

    public void setKeyContent(String keyContent) {
        this.keyContent = keyContent == null ? null : keyContent.trim();
    }
}