package com.pupupu.ribbonrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 假设当前有个需求为每个服务要求被调用5次，那么这个负载均衡算法就需要自定义了。
 * 当前类的源码是基于 Ribbon 默认的 RandomRule 负载均衡代码修改的，代码网址在github上：
 * https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java
 *
 * @author Summer
 * @version 1.0
 * @date 2019/10/31 19:10
 */
public class IRandomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            // int index = chooseRandomInt(serverCount);
            // server = upList.get(index);

            //
            // 修改的关键代码在这里
            //
            if(total < 3){
                server = upList.get(currentIndex);
                total++;
            }else{
                if(currentIndex == (upList.size() - 1)){
                    currentIndex = 0;
                }else{
                    currentIndex++;
                }
                server = upList.get(currentIndex);
                total = 0;
            }
            // END 自定义代码结束

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}
