package mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpk on 2019/3/19
 **/
public class MyTomcat {

    private int port = 8080;

    private Map<String,String> urlServletMap = new HashMap<>();

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start(){
        //初始化url与对应处理的servlet关系
        initServletMapping();

        //利用socket建立Keep-Alive
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start ....!");

            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            MyRequest myRequest = new MyRequest(inputStream);
            MyResponse myResponse = new MyResponse(outputStream);

            //请求分发
            dispath(myRequest,myResponse);
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void initServletMapping(){
        for (ServletMapping servletMapping : ServletConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    private void dispath(MyRequest request,MyResponse response){

        String clazz = urlServletMap.get(request.getUrl());

        //反射
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat(8081).start();
    }
}
