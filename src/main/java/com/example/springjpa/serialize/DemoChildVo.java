package com.example.springjpa.serialize;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DemoChildVo implements Serializable {
    public ConcurrentHashMap hashMap;



    public List<String> listchild;

    public ConcurrentHashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(ConcurrentHashMap hashMap) {
        this.hashMap = hashMap;
    }
    public List<String> getListchild() {
        return listchild;
    }

    public void setListchild(List<String> listchild) {
        this.listchild = listchild;
    }

    @Override
    public String toString() {
        return "DemoChildVo{" +
                "hashMap=" + hashMap +
                ", listchild=" + listchild +
                '}';
    }
}
