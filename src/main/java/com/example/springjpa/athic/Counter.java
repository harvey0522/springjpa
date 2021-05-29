package com.example.springjpa.athic;

import java.util.TreeSet;

public class Counter implements Comparable<Counter> {
    char chars;
    int counter=1;

    @Override
    public int compareTo(Counter o) {
        if(counter>o.counter){
            return -1;
        }else if(counter<o.counter){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Counter{" +
                "chars=" + chars +
                ", counter=" + counter +
                '}';
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(2.0/0);
        TreeSet<Counter> ts=new TreeSet<Counter>();
        Counter cls =new Counter();
        byte b=49;
        byte x='?';
        System.out.println(">>>>>"+(b==x));
        cls.chars='a';
        cls.counter=cls.counter++;

        Counter cls1 =new Counter();
        cls1.chars='b';
        cls1.counter=cls.counter+2;

        Counter cls2 =new Counter();
        cls2.chars='c';
        cls2.counter=cls.counter+4;

        ts.add(cls);
        ts.add(cls1);
        ts.add(cls2);

        ts.stream().forEach(key-> System.out.println(key.toString()));
    }

}

