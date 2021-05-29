package com.example.springjpa.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MySeirialize implements Serialization {
    @Override
    public byte getContentTypeId() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {

        return new MySeriObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return null;
    }
}
