package com.loujm;

public abstract class MyHttpServlet {

    //定义常量
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest myRequest, MyResponse myResponse);
    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    /**
     * 根据请求方式来判断使用GET还是POST
     * @param myRequest
     * @param myResponse
     */
    public void service(MyRequest myRequest, MyResponse myResponse) {
        if(METHOD_GET.equals(myRequest.getRequestMethod())) {
            doGet(myRequest, myResponse);
        }else if(METHOD_POST.equals(myRequest.getRequestMethod())) {
            doPost(myRequest,myResponse);
        }
    }
}
