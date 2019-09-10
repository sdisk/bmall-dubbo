package com.hq.bamllordercomsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 在集群负载均衡时，Dubbo 提供了多种均衡策略，缺省为 random 随机调用。
 * 负载均衡策略
 * 1.Random LoadBalance 权重
 * 2.RoundRobin LoadBalance 按公约后的权重设置轮询比率
 * 3.LeastActive LoadBalance 最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差
 *   使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大
 * 4.ConsistentHash LoadBalance
 *  - 一致性 Hash，相同参数的请求总是发到同一提供者。
 *  - 当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动
 *  - 缺省只对第一个参数 Hash，如果要修改，请配置 <dubbo:parameter key="hash.arguments" value="0,1" />
 *  - 缺省用 160 份虚拟节点，如果要修改，请配置 <dubbo:parameter key="hash.nodes" value="320" />
 *
 *  服务降级
 *  当服务器压力过大时,我们可以通过服务降级来使某些非关键服务的调用变得简单,
 *  可以对其直接进行屏蔽,即客户端不发送请求直接返回null,
 *  也可以正常发送请求当请求超时或不可达时再返回null;
 *  服务降级的相关配置可以直接在dubbo-admin的监控页面进行配置;
 *  通常是基于消费者来配置的,在dubbo-admin找到对应的消费者想要降级的服务,
 *  点击其后面的屏蔽或容错按钮即可生效；
 *  其中,屏蔽按钮点击表示放弃远程调用直接返回空,而容错按钮点击表示继续尝试进行远程调用当调用失败时再返回空
 *
 *  集群容错
 *　在集群调用失败时，Dubbo 提供了多种容错方案，缺省为 failover 重试。下面列举dubbo支持的容错策略：
 *
 * 　　　　Failover Cluster：失败自动切换，当出现失败，重试其它服务器。通常用于读操作，但重试会带来更长延迟。可通过 retries="XXX" 来设置重试次数(不含第一次)。
 *
 * 　　　　Failfast Cluster：快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，比如新增记录。
 *
 * 　　　　Failsafe Cluster：失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。
 *
 * 　　　　Failback Cluster：失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。
 *
 * 　　　　Forking Cluster：并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读操作，但需要浪费更多服务资源。可通过 forks="2" 来设置最大并行数。
 *
 * 　　　　Broadcast Cluster：广播调用所有提供者，逐个调用，任意一台报错则报错 [2]。通常用于通知所有提供者更新缓存或日志等本地资源信息。
 *
 *  　　　　配置如下：@Reference(cluster = "failsafe")这里表示使用失败安全的容错策略
 *
 *  还有一种springcloud默认的容错策略Hystrix；Hystrix旨在通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
 *  Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能
 */

@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class BamllOrderComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BamllOrderComsumerApplication.class, args);
    }

}
