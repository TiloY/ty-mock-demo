package com.ty.tymockdemo.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/27 15:31
 * @Version : 1.0.0
 **/
public class ThreadPoolExe {


    private ThreadPoolExe() {
    }

    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8,
            10, 1L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(10));

    private static ThreadPoolExe getInstance() {
        return ThreadPoolExe.getInstance();
    }

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return  getInstance().poolExecutor;
    }


}
