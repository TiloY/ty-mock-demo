package com.ty.tymockdemo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/7/16 16:53
 * @Version : 1.0.0
 **/
public class Solution {


    interface A {
        void a();
    }

    static class AImpl implements A {
        @Override
        public void a() {
            System.out.println("a 方法");
        }
    }

    interface B {
        void b();
    }

    static class BImpl implements B {
        @Override
        public void b() {
            System.out.println("b 方法");
        }
    }

    interface C {
        void c();
    }


    static class CImpl implements C {
        @Override
        public void c() {
            System.out.println("c 方法");
        }
    }

    interface D {
        void d();
    }

    static class DImpl implements D {
        @Override
        public void d() {
            System.out.println("c 方法");
        }
    }



    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(4);
        Map<String, Class> staresMap  = new HashMap<>();
        staresMap.put("a",AImpl.class);
        staresMap.put("b",BImpl.class);
        staresMap.put("c",CImpl.class);
        staresMap.put("d",DImpl.class);

        for (String key : staresMap.keySet()) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    Class clazz = staresMap.get(key);
                      tes(key , clazz);
                }


                // 这里优化成策略模式   可以查表
                private void tes(String key , Class clazz) {
                    if("a".equalsIgnoreCase(key)  ){
                        AImpl o = null;
                        try {
                            o = (AImpl)clazz.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        o.a();
                    }else if("b".equalsIgnoreCase(key) ){
                        BImpl o = null;
                        try {
                            o = (BImpl)clazz.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        o.b();
                    }else if("c".equalsIgnoreCase(key) ){
                        CImpl o = null;
                        try {
                            o = (CImpl)clazz.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        o.c();
                    }else if("d".equalsIgnoreCase(key) ){
                        DImpl o = null;
                        try {
                            o = (DImpl)clazz.newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        o.d();
                    }
                }
            });
        }

    }


}
