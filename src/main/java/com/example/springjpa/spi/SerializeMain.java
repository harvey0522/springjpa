package com.example.springjpa.spi;

import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.serialize.ObjectOutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class SerializeMain {
    public static void main(String[] args) throws IOException {
        ExtensionLoader<Serialization> pLoader=ExtensionLoader.getExtensionLoader(Serialization.class);
        Serialization service=pLoader.getExtension("myser");
        FileOutputStream fileOutputStream=new FileOutputStream("spi.txt");
        ObjectOutput objectOutput=service.serialize(null,fileOutputStream);
        StringBuilder s=new StringBuilder("a");
        for(int i=0;i<1024000;i++){
            s.append("b");
        }
        //System.out.println(s.toString());
        objectOutput.writeObject(s.toString());
        objectOutput.flushBuffer();
        fileOutputStream.close();
    }
}
