package com.loujm;

import java.io.IOException;

public class MyServlet extends MyHttpServlet{

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("mytomcat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("tomcat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
