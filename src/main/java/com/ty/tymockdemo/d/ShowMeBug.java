package com.ty.tymockdemo.d;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/16 15:47
 * @Version : 1.0.0
 **/


// 可以引⼊的库和版本相关请参考 “环境说明”
// 请通过输出方法打印代码运行结果，“运行”后在控制台查看输出信息
// `ShowMeBug` ⼊⼝类和 `public static void main(String[] args)` ⼊⼝⽅法请勿修改，以防执⾏失败

import java.util.*;

public class ShowMeBug {


    public static List<String> solution(String exp) {
        // write your code here
        /**
         * 诗云科技的下午茶好吃死了
         * 诗云科技的下午茶难吃死了
         * 诗云科技的宵夜好吃死了
         * 诗云科技的宵夜难吃死了
         */
        String[] split = exp.split("\\[");
        System.out.println(Arrays.toString(split));
        Map<String,  List<String>> map = new HashMap<>();
        List<String> lastArr = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            map.put(split[i],new LinkedList<>()) ;
            if(split[i].contains("]") && split[i].contains("|")){
                String[] arr = split[i].split("]");
                if(arr.length == 2 ){
                    String[] arr2 = arr[0].split("\\|");
                    for (String s : arr2) {
                        (map.get(split[i])).add(s );
                    }
                    lastArr.add( arr[1]);
                }else {
                    String[] arr2 = arr[0].split("\\|");
                    for (String s : arr2) {
                        (map.get(split[i])).add(s );
                    }
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(null ==(entry.getValue()) || entry.getValue().size() == 0){
                System.out.println(entry.getKey());
            }else{
                List<String> value = entry.getValue();
                for (String s : value) {
                    System.out.println(s);
                }
            }

        }

        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        String exp = "诗云科技的[下午茶|宵夜][好吃|难吃]死了";
        solution(exp);
        //System.out.println(solution(exp));

        System.out.println("==========================");

        exp = "[上|这|下]道题有点[难|简单]";
        //System.out.println(solution(exp));
    }
}

