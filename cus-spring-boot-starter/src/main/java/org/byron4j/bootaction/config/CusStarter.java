package org.byron4j.bootaction.config;

public class CusStarter {
    private CusStarterProperties cusStarterProperties;

    public CusStarter() {
    }

    public CusStarter(CusStarterProperties cusStarterProperties) {
        this.cusStarterProperties = cusStarterProperties;
    }

    public String cusStarter(){
        System.out.println("配置参数为：" + cusStarterProperties.getArg());
        return cusStarterProperties.getArg();
    }
}
