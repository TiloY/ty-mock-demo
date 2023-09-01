package com.ty.tymockdemo.A;

import java.util.Arrays;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/14 14:29
 * @Version : 1.0.0
 **/
public class Mssss {
    public static final String REGEX = "  ";


//    反转字符串中的单词 III
//    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//    样例1:
//            [输入]
//            "Let's take LeetCode contest"
//            [输出]
//            "s'teL ekat edoCteeL tsetnoc"
//            [说明]
//    在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。


    public static void main(String[] args) {

        String srt = "Let's take LeetCode contest";
        //  "s'teL ekat edoCteeL tsetnoc"
        String[] arr = srt.split(" ");
        System.out.println(Arrays.toString(arr));
        String res = "";

        for (String s : arr) {
            StringBuffer sb = new StringBuffer();
            res += sb.append(s).reverse().toString() + " ";
        }

        System.out.println(res.trim());

    }
}

