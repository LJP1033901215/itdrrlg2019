package com.itdr.common;
//统一创建返回状态码和状态信息的类
public class Const {
    public static final String LOGINUSER="login_user";
    public static final String TRADE_SUCCESS ="TRADE_SUCCESS";
    public static final String AUTOLOGINTOKEN = "autoLoginToken";
    public static final String JESSIONID_COOKIE = "JESSIONID_COOKIE";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    /*成功的状态码*/
    public static final int SUCESS = 200;

    /*失败的状态码*/
    public static final int ERROR = 100;

    //使用枚举
    public enum UsersEnum{
        NEED_LOGIN(2,"需要登录"),
        NO_LOGIN(1001,"用户未登录");

        private int code;
        private  String desc;
        private  UsersEnum(int code ,String desc){
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}

