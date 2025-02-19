package org.example.springboot_project.exception;

public class CustomException extends RuntimeException{

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CustomException (String msg) {
        this.msg = msg;
    }
}
