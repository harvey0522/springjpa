package com.example.springjpa.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.threadlocal.NamedInternalThreadFactory;
import org.apache.dubbo.common.threadpool.ThreadPool;
import org.apache.dubbo.common.threadpool.support.AbortPolicyWithReport;

import java.util.concurrent.*;

public class MyDubboThreadPool implements ThreadPool {
    @Override
    public Executor getExecutor(URL url) {
        String name = url.getParameter("threadname", "Dubbo");
        int threads = url.getParameter("threads", 200);
        int queues = url.getParameter("queues", 0);
        return new ThreadPoolExecutor(threads, threads, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)(queues == 0 ? new SynchronousQueue() : (queues < 0 ? new LinkedBlockingQueue() : new LinkedBlockingQueue(queues))), new NamedInternalThreadFactory(name, true), new MyAbortPolicy());
    }
}
