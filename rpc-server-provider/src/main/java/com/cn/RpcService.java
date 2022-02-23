package com.cn;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description @RpcService
 * @Author: Levi.Ding
 * @Date: 2022/2/23 14:52
 * @Version V1.0
 */
@Target(ElementType.TYPE) //类｜接口
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RpcService {
    Class<?> value();
}
