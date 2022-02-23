package com.cn;

import java.io.Serializable;

/**
 * @Description RcpRequest
 * @Author: Levi.Ding
 * @Date: 2022/2/22 15:42
 * @Version V1.0
 */
public class RcpRequest  implements Serializable {

    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
