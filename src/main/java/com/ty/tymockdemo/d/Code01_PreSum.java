package com.ty.tymockdemo.d;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/15 14:56
 * @Version : 1.0.0
 **/
public class Code01_PreSum {


    public static void main(String[] args) {

    }

    public static class RangeSum2 {
        private int[] preSum;

        public RangeSum2(int[] array) {
            int N = array.length;
            preSum = new int[N];
            preSum[0] = array[0];
            for (int i = 0; i < N; i++) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }
    }
}
