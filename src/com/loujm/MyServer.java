package com.loujm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    /**
     * 启动服务端接收程序
     * @param port
     */
    public static void startServer(int port) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        //定义服务端套接字
        ServerSocket serverSocket = new ServerSocket(port);
        //定义客户端套接字
        Socket socket = null;

        while(true) {
            socket = serverSocket.accept();

            //获取输入输出流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //定义请求对象
            MyRequest myRequest = new MyRequest(inputStream);
            //定义响应对象
            MyResponse myResponse = new MyResponse(outputStream);

            String clazz = new MyMapping().getMapping().get(myRequest.getRequestUrl());
            if(clazz!=null) {
                Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
                //根据myServletClass创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(myRequest, myResponse);
            }
        }
    }

    public static void main(String[] args) {
        try {
            startServer(20000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
