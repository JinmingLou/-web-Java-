package com.loujm;

import java.util.HashMap;

public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<String,String>();

    static {
        mapping.put("/mytomcat", "com.loujm.MyServlet");
    }

    public HashMap<String,String> getMapping() {
        return mapping;
    }

}





































