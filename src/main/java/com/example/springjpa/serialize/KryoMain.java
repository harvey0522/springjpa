package com.example.springjpa.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.example.springjpa.entry.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 如果时dubbo的kryo会降级为jdk序列化
 * 服务端家字段 且已部署不影响消费端
 *
 * 服务端发布依赖，但未上线。如果有依赖对象 需要等否则出现序列化异常
 */
public class KryoMain {
    public static void main(String[] args) throws FileNotFoundException {
        ThreadLocal<Kryo> tl=new ThreadLocal<Kryo>(){
            @Override
            protected Kryo initialValue() {
                return new Kryo();
            }
        };
        Kryo kryo=tl.get();
        //seriliaze(kryo);
        unseialize(kryo);

    }

    public static void seriliaze(Kryo kryo) throws FileNotFoundException {
        OutputStream outputStream=new FileOutputStream("person.txt");
        Output output=new Output(outputStream);
        Product product=new Product();
        product.setId(10000000);
        product.setName("凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三凯瑟琳 劳伦斯的三");
        //product.setState((byte)129);
        kryo.writeObject(output,product);
        output.close();
    }

    public static void unseialize(Kryo kryo) throws FileNotFoundException {
          Input input=new Input(new FileInputStream("person.txt"));

        Product product1= kryo.readObject(input,Product.class);
        input.close();
        System.out.println(product1.toString());
    }
}
