package com.ty.tymockdemo.d;

import java.util.Arrays;

public enum L {
    Q(0, "不及格", "(0,60)"),
    W(0, "中", "[60,80)"),
    E(0, "良", "[80,90)"),
    R(0, "优", "[90,100]"),
    ;
    private int code;
    private String name;
    private String value;

    L(int code, String name, String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static L[] getAllRes(){
        L[] values = L.values();
        System.out.println(Arrays.toString(values()));
        return values ;
    }
}
