package mytomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhangpk on 2019/3/19
 **/
public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        /*HTTP响应协议
        HTTP/1.1 200 OK
        Content-length:3242
        Content-Type: text.html*/
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP1.1 200 OK\n")
                .append("Content-Type: text.html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</html></body>");
            outputStream.write(httpResponse.toString().getBytes());
            System.out.println(httpResponse.toString());
            outputStream.close();


    }
}
