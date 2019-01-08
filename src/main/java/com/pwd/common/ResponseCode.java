package com.pwd.common;

public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    //实际上就是上面枚举代表的内容（那些正确的0和1不是我们规定的，可以通过枚举类进行一个明文规定，修改方便）
    private final int code;
    private final String desc;

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
