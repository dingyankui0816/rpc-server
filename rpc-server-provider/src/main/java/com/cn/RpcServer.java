package com.cn;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description RpcServer
 * @Author: Levi.Ding
 * @Date: 2022/2/23 14:56
 * @Version V1.0
 */
@Component
@DependsOn(value = {"rpcConfig"})
public class RpcServer implements ApplicationContextAware, InitializingBean {

    ExecutorService executorService = Executors.newCachedThreadPool();

    private Map<String,Object> beanMap = Maps.newHashMap();

    @Autowired
    private RpcConfig rpcConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(rpcConfig.getPort());
            while (true){
                Socket accept = serverSocket.accept();
                executorService.execute(new ProcessorHandler(beanMap,accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (CollectionUtils.isEmpty(beansWithAnnotation)){
            return;
        }
        for (Object value : beansWithAnnotation.values()) {
            RpcService annotation = value.getClass().getAnnotation(RpcService.class);
            beanMap.put(annotation.value().getName(),value);
        }
    }
}
