package com.example.springjpa.spi;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DemoSieralize implements Serializable {
    public String abc="123";
    public LinkedHashMap linkedHashMap=new LinkedHashMap(14,17);
    public ReentrantLock reentrantLock=new ReentrantLock(false);

}
