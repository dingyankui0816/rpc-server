package com.cn;

/**
 * @Description HelloService
 * @Author: Levi.Ding
 * @Date: 2022/2/22 15:30
 * @Version V1.0
 */
@RpcService(value = IHelloService.class,version = "2.0")
public class HelloServiceImplV2 implements IHelloService {


    @Override
    public String sayHello(String content) {
        System.out.println("【2.0】request in sayHello:"+content);
        return "Say Hello:"+content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【2.0】request in saveUser:"+user);
        return "SUCCESS";
    }
}