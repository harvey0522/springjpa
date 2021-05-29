package com.example.springjpa.athic.proxy;

public class CarImpl implements Car{
    @Override
    public String say(String param) {
        System.out.println("carimpl....param:::"+param);
        stop(param);
        return "[hello CarImpl say]";
    }

    @Override
    public int[] stop(String param) {
        System.out.println("stop......."+param);
        return new int[]{1,2};
    }
}
