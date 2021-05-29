package com.example.springjpa.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.common.threadpool.ThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class PoolMain {
    public static void main(String[] args) {
        ExtensionLoader<ThreadPool> pLoader=ExtensionLoader.getExtensionLoader(ThreadPool.class);
        ThreadPool service=pLoader.getExtension("fixed");
        Map<String,String> param=new HashMap<String,String>();
        param.put("threads","1");
        param.put("queues","1");
        param.put("threadname","xbbbb");
        URL url = new URL("dubbo","localhost",20881,param);
        Executor executor=service.getExecutor(url);
        Runnable r1=()->{
            try {
                Thread.sleep(3000l);
                System.out.println("start.........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.execute(r1);
        executor.execute(r1);
        executor.execute(r1);
    }
}
