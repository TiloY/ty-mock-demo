package com.ty.tymockdemo.threaddemo;

import java.io.Serializable;


public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean ret;
    private String message;
    private Object data;

    public Result() {
        super();
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public void setData(Object data) {
		this.data = data;
	}

	@Override
    public String toString() {
        return "Result [ret=" + ret + ", message=" + message + ", data=" + data
                + "]";
    }

}
