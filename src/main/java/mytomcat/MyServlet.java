package mytomcat;

/**
 * Created by zhangpk on 2019/3/19
 * 抽象出servlet类还记得doGet、doPost吗
 **/
public abstract class MyServlet {

    public abstract void doGet(MyRequest request,MyResponse response);

    public abstract void doPost(MyRequest request,MyResponse response);

    public void service(MyRequest request,MyResponse response) {
        if (request.getMethod().equalsIgnoreCase("POST"))
            doPost(request,response);
        else
            doGet(request,response);
    }
}
