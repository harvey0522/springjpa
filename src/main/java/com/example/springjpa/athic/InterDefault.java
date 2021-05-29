package com.example.springjpa.athic;

public interface InterDefault {

    String a =null;

    default public void getName(){
        System.out.println("XXXX");
    }


    public void getAge();

    public abstract void getPhone();
}
