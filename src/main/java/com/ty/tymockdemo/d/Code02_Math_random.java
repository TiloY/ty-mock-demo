package com.ty.tymockdemo.d;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/15 15:04
 * @Version : 1.0.0
 **/
public class Code02_Math_random {

    public static void main(String[] args) {
        System.out.println("开始测试");
        // [0 1) 等概率返回     数学做不到但是计算机可以

        int testTime = 1000000;
        int count = 0;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }

        System.out.println((double) count / (double) testTime);


        System.out.println("======================分割=======================");

        // 0 -- 8
        count = 0;
        double ans2 = Math.random() * 8;
        for (int i = 0; i < testTime; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTime);

        System.out.println("======================分割=======================");

        int k = 9;
        // [0--k) ----- [0 8]
        int ansss = (int) (Math.random() * k);

        // 对数器 ’
        // Math.random()



    }


    /**
     * 返回 【0 1 ）
     *      0 x*2
     */
    public static  double xToPower2(){
        return Math.max(Math.random(), Math.random());
    }

}
