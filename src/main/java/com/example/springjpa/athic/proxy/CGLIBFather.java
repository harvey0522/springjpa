package com.example.springjpa.athic.proxy;

import javax.persistence.criteria.CriteriaBuilder;

public  class CGLIBFather {
    public    void sayHello(Integer param){
        System.out.println("sayHello........+"+param);
        start(""+param);
    }
    public void start(String param){
        System.out.println("start........+"+param);
    }
}
