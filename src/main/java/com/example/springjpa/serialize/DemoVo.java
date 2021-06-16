package com.example.springjpa.serialize;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DemoVo implements Serializable {
    public DemoVo(String a){

    }
    public ConcurrentHashMap hashMap;
    public List<String> list;
    private String aa;

    public DemoChildVo demoChildVo;

    public LinkedHashMap linkedHashMap;



    public ConcurrentHashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(ConcurrentHashMap hashMap) {
        this.hashMap = hashMap;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public DemoChildVo getDemoChildVo() {
        return demoChildVo;
    }

    public void setDemoChildVo(DemoChildVo demoChildVo) {
        this.demoChildVo = demoChildVo;
    }

    public LinkedHashMap getLinkedHashMap() {
        return linkedHashMap;
    }

    public void setLinkedHashMap(LinkedHashMap linkedHashMap) {
        this.linkedHashMap = linkedHashMap;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return "DemoVo{" +
                "hashMap=" + hashMap +
                ", list=" + list +
                ", demoChildVo=" + demoChildVo +
                ", linkedHashMap=" + linkedHashMap +
                '}';
    }
}
