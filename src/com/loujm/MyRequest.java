package com.loujm;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {

    //请求方法 GET/POST
    private String requestMethod;
    //请求地址
    private String requestUrl;

    public MyRequest(InputStream inputStream) throws IOException {
        //缓冲
        byte[] buffer = new byte[1024];
        //读取数据长度
        int len = 0;
        //定义请求的变量
        String str = null;

        if ((len = inputStream.read(buffer)) > 0) {
            str = new String(buffer, 0, len);
        }
        //GET / HTTP/1.1
        String date = str.split("\n")[0];
        String[] params = date.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}









































