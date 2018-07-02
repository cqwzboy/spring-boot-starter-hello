package com.fuqinqin.code.service;

public class HelloServiceImpl implements HelloService {

    private String msg;

    @Override
    public String sayHello() {
        return "Hello "+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
