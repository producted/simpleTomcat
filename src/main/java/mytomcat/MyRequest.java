package mytomcat;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangpk on 2019/3/18
 **/
@Data
public class MyRequest {

    private String url;
    private String method;


    @Override
    public String toString() {
        return "MyRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public MyRequest(InputStream inputStream) throws IOException {

        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes, 0, length);
            String httpHead = httpRequest.split("\n")[0];
            url = httpHead.split("\\s")[1];
            method = httpHead.split("\\s")[0];
            System.out.println(this.toString());
        }else {
            url = "";
            method = "";
        }

//            请求行length请求行Http请求协议
//            请求行:GET /api HTTP/1.1
//            请求头:Accept:*/*
//            请求编码：Accept-Encoding:gzip,deflate
//            Host：localhost:8080
//            Connection:Keep-Alive

    }
}
