# tomcat_mini

手写一个迷你版的tomcat，很简单！

##预览

![custom cat](https://uacoding.cn/images/other/customCat.png)

对request，response，servlet进行so simple custom；

这里我定义了两个固定的反射路径，毕竟tomcat启动加载也就是通过dispatchservlet并结合spring扫描拿到这些映射的路径，貌似没毛病；

最后通过socket访问，java反射返回给web。
