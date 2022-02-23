package com.cn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description todo
 * @Author: Levi.Ding
 * @Date: 2022/2/23 15:12
 * @Version V1.0
 */
@ComponentScan
@Configuration
public class RpcConfig {
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private int port = 8080;
}
