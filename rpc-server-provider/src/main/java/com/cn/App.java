package com.cn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        IHelloService helloService = new HelloServiceImpl();
//        RpcProxyServer rpcProxyServer = new RpcProxyServer();
//        rpcProxyServer.publisher(helloService,8080);

        ApplicationContext context = new AnnotationConfigApplicationContext(RpcConfig.class);
        ((AnnotationConfigApplicationContext)context).start();
    }
}
