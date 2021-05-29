package com.example.springjpa.spi;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.common.serialize.ObjectOutput;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MySeriObjectOutput extends ObjectOutputStream implements ObjectOutput {

    public MySeriObjectOutput(OutputStream out) throws IOException {
        super(out);
        System.out.println("自定义序列化");
    }


    @Override
    public void writeBool(boolean v) throws IOException {
        super.writeBoolean(v);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        super.writeByte(v);
    }

    @Override
    public void writeShort(short v) throws IOException {
        super.writeByte(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        super.writeByte(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        super.writeLong(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        super.writeFloat(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        super.writeDouble(v);
    }

    @Override
    public void writeUTF(String v) throws IOException {
        super.writeUTF(v);
    }

    @Override
    public void writeBytes(byte[] v) throws IOException {
        super.write(v);
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
        super.write(v,off,len);
    }

    @Override
    public void flushBuffer() throws IOException {
        super.flush();
    }
}
