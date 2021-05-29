package com.example.springjpa.athic.proxy;

public class BlackCarImpl implements Car{
    @Override
    public String say(String param) {
        System.out.println("blcakcarimpl....param:::"+param);
        stop(param);
        return "[hello say]";
    }

    @Override
    public int[] stop(String param) {
        System.out.println("blcakcarimpl stop......."+param);
        return new int[]{2};
    }
}
