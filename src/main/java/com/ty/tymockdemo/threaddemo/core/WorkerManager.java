package com.ty.tymockdemo.threaddemo.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description :
 * @Author : 田迎
 * @Date : 2023/8/27 17:26
 * @Version : 1.0.0
 **/
public class WorkerManager<T, E> {

    private int queueSize = 8;
    private int poolSize = 10;
    private ConcurrentLinkedQueue<AbsTask<T, E>> queueSource = null;
    private List<E> rets = null;
    private CompletionService<E> pool;

    public WorkerManager(List<AbsTask<T, E>> list) {
        queueSource = new ConcurrentLinkedQueue<AbsTask<T, E>>();
        for (AbsTask<T, E> t : list) {
            queueSource.add(t);
        }

    }

    public WorkerManager(int queueSize, int poolSize, List<AbsTask<T, E>> list) {
        this.queueSize = queueSize;
        this.poolSize = poolSize;
        queueSource = new ConcurrentLinkedQueue<AbsTask<T, E>>();
        for (AbsTask<T, E> t : list) {
            queueSource.add(t);
        }
    }

    public List<E> run() {
        System.out.println("run");
        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(this.queueSize,
                this.poolSize, 1L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(this.poolSize));
        pool = new ExecutorCompletionService<E>(threadpool);
        rets = new ArrayList<E>();
        try {
            int num = 0;

            while (!queueSource.isEmpty()) {

                if (threadpool.getActiveCount() < this.poolSize) {
                    AbsTask<T, E> task = queueSource.poll();
                    pool.submit(task);
                    num++;
                    Thread.sleep(10);
                } else {
                    Thread.sleep(50);
                }
            }
            System.out.println(String.format("========", num));
            for (int i = 0; i < num; i++) {
                rets.add(pool.take().get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadpool.shutdown();
        }
        return rets;
    }

}