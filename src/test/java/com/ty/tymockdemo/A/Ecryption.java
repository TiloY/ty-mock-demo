package com.ty.tymockdemo.A;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/22 2:47
 * @Version : 1.0.0
 **/
public class Ecryption {

    public static void main(String[] args) {
        String str = "welcome";
        String des = des(str);
        System.out.println(des);
    }

    private static String des(String str) {
        if ("".equalsIgnoreCase(str)){
            return "";
        }

        StringBuilder result=new StringBuilder(str.substring(str.length()-1));
        for(int i=0;i<str.length()-1;i++){
            char c=(char)(str.charAt(i)+3);
            result.append(c);
        }
        return result.toString();
    }




}
