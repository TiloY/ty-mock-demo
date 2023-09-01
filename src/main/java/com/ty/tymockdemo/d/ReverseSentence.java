package com.ty.tymockdemo.d;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/24 19:49
 * @Version : 1.0.0
 **/


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 1. 给定一个字符数组，里面是一个句子，请将此句子以单词的维度反转：
 * 输入: "this is a sentence"
 * 输出: "sentence a is this"
 * <p>
 * 要求：空间复杂度O(1)
 * @param
 */
public class ReverseSentence {
    public static void main(String[] args) {
        ReverseSentence rs = new ReverseSentence();
        //rs.run();
        //System.out.println(652.73+352.40+247.54+319.04+267.08+826.05+1080);
        PriorityQueue<Object> objects = new PriorityQueue<>();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        //objectObjectHashMap.put();
    }

    void run() {
        String sentence = " this is a sentence ";
        char[] array = sentence.toCharArray();

        System.out.println("'" + new String(array) + "'");

        reverseSentenceArray(array);
        System.out.println("'" + new String(array) + "'");
    }

    void reverseSentenceArray(char[] array) {
        System.out.println(Arrays.toString(array));
        if(null == array || array.length == 0){
            return;
        }

        reverseSentenceArray(array,0 ,array.length -1);

        int of = 0 ;
        for (int i = 0; i < array.length; i++) {
            if(' '==array[i]){
                reverseSentenceArray(array,of ,i -1);
                of = i+1;
            }
        }
        reverseSentenceArray(array,of ,array.length -1);

    }

    private void reverseSentenceArray(char[] array, int l, int r) {
       while (l<r){
           char tmp = array[l];
           array[l++] = array[r];
           array[r--] = tmp ;
       }
    }
}
