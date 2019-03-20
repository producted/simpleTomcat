package mytomcat;

import java.io.IOException;

/**
 * Created by zhangpk on 2019/3/19
 **/
public class BigFaceServlet extends MyServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        try {
            response.write("get resp love gril is bigFace!....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        try {
            response.write("post resp love gril is bigFace!....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
