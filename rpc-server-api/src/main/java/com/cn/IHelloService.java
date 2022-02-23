package com.cn;

/**
 * @Description IHelloService
 * @Author: Levi.Ding
 * @Date: 2022/2/22 15:26
 * @Version V1.0
 */
public interface IHelloService {
    String sayHello(String content);
    /**
     * @Description: 保存User
     * @author Levi.Ding
     * @date 2022/2/22 15:28
     * @param user :
     * @return : java.lang.String
     */
    String saveUser(User user);
}
