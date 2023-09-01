package com.ty.tymockdemo.threaddemo.core;

import java.util.concurrent.Callable;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/27 17:26
 * @Version : 1.0.0
 **/
public abstract class AbsTask<T, E> implements Callable<E> {
    private T t;

    public AbsTask(T t) {
        this.t = t;
    }

    @Override
    public E call() throws Exception {
        return work(this.t);
    }

    public abstract E work(T t);
}