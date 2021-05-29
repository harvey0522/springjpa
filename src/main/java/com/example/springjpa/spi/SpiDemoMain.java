package com.example.springjpa.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemoMain {
    public static void main(String[] args) {

        ExtensionLoader<SpiDemoService> pLoader=ExtensionLoader.getExtensionLoader(SpiDemoService.class);
        SpiDemoService service=pLoader.getExtension("s1");
        SpiDemoService service2=pLoader.getExtension("s2");
        pLoader.getAdaptiveExtension();
        service.say("222");
        pLoader.getLoadedExtensions().forEach(key-> System.out.println(key));
//        pLoader.getDefaultExtension().say("333");
        //SpiDemoService service=pLoader.getExtension("s2");
        //service.say("222");

    }


    public void test1(){
        ServiceLoader<SpiDemoService> serviceLoader= ServiceLoader.load(SpiDemoService.class);
        ServiceLoader<SpiOrderService> orderLoader= ServiceLoader.load(SpiOrderService.class);
           /*for(SpiDemoService serv : serviceLoader){
               serv.say("i");
           }*/
        Iterator<SpiDemoService> itera= serviceLoader.iterator();
        while(itera.hasNext()){
            itera.next().say("hhhhh");
            //break;
        }
        System.out.println("over!!!!");
    }
}
