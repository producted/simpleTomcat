package mytomcat;

import lombok.Data;

/**
 * Created by zhangpk on 2019/3/19
 **/
@Data
public class ServletMapping {

    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }


}
