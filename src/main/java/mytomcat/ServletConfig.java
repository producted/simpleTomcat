package mytomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpk on 2019/3/19
 **/
public class ServletConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("bigface","/bigface","mytomcat.BigFaceServlet"));
        servletMappingList.add(new ServletMapping("myworld","/myworld","mytomcat.MyWorldServlet"));
    }
}
