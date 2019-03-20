package mytomcat;

import java.io.IOException;

/**
 * Created by zhangpk on 2019/3/19
 **/
public class MyWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get resp i love life!...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post resp i love life!...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
