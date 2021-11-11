package com.example.springjpa.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 测试
 * http://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index
 *
 */
public class WchatTest {
    public static void main(String[] args) {
//        getAccesstoken();
       getUserInfo();
    }

    /**
     * ticket:
     * gQFH8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyWDZkcW9oeEljQUUxSmY1OGh4Y3EAAgTPin9hAwSAOgkA
     */
    public static void paramApi(){
        String token="50_SwDXIsT-6fD3z-2npRf0HDWR8ekPv2xt-kUCc63h5aUxlZsQZve9POLS7kObhmjHwKnmuRP8tFpXxUBx55uM6q5-exo6dTLM32vVvmgUXpjJ-kIbTeRESuFcK7LxtFJzBRiO5fUvZA912TDyGLCgADAYDU";
        String url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+token;

        try {
            URL getUrl=new URL(url);
            HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);


            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);


            String message = new String(b, "UTF-8");
            System.out.println(message);
            JSONObject json = JSONObject.parseObject(message);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 50_SwDXIsT-6fD3z-2npRf0HDWR8ekPv2xt-kUCc63h5aUxlZsQZve9POLS7kObhmjHwKnmuRP8tFpXxUBx55uM6q5-exo6dTLM32vVvmgUXpjJ-kIbTeRESuFcK7LxtFJzBRiO5fUvZA912TDyGLCgADAYDU
     */
    public static void getAccesstoken(){
        String code="CODE";
        /*String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx894d8f4533581eb6&secret=95011ac70909e8cca2786217dd80ee3f&code="+code
                +"&grant_type=authorization_code";*/
        String appid="wx28264d085b926f2b";
        String secret="c916d7d442b3ce416118aa9e209937de";
        String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        //System.out.println(code);
        String openId="";
        try {
            URL getUrl=new URL(url);
            HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);


            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);


            String message = new String(b, "UTF-8");
            System.out.println(message);
            JSONObject json = JSONObject.parseObject(message);

            openId = json.getString("openid");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * access_token:50_J7uy3oKrrjCbBkJ_a8os2XX-N7oNSVmPrp1pfQAsQ0cC683OK6OBWKgjkx3QuezfPSa1J5c5Bq50rAdKdD6pLn1SF0QdC478ct30r7kyIcVC4i6gLL05zUMo-lFhlWaxhamie8lskxewYhrdJNYeAIAOSD
     */
    public static void getUserInfo(){
        String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token50_SwDXIsT-6fD3z-2npRf0HDWR8ekPv2xt-kUCc63h5aUxlZsQZve9POLS7kObhmjHwKnmuRP8tFpXxUBx55uM6q5-exo6dTLM32vVvmgUXpjJ-kIbTeRESuFcK7LxtFJzBRiO5fUvZA912TDyGLCgADAYDU&lang=zh_CN";
        //System.out.println(code);
        String openId="ooWwk6AqJOtrnK6b8Qpaxbg8mQOk";
        try {
            URL getUrl=new URL(url);
            HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);


            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] b = new byte[size];
            is.read(b);


            String message = new String(b, "UTF-8");
            System.out.println(message);
            JSONObject json = JSONObject.parseObject(message);

            openId = json.getString("openid");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
