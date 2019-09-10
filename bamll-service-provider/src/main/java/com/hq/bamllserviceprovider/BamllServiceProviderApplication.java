package com.hq.bamllserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * dubbo与springboot整合的三种方式
 *  1.导入dubbo-starter，在application.properties文件中配置属性，使用@Service暴露服务，使用@Referen引用服务
 *  在启动类上使用@EnableDubbo，开启dubbo配置扫码
 *  2.导入dubbo-starter，保留dubbo配置文件，在启动类上使用@ImportResource(locations="classpath:provider.xml")
 *  3.使用注解API的方式，API 属性与配置项一对一
 *  // 服务实现
 * XxxService xxxService = new XxxServiceImpl();
 *
 * // 当前应用配置
 * ApplicationConfig application = new ApplicationConfig();
 * application.setName("xxx");
 *
 * // 连接注册中心配置
 * RegistryConfig registry = new RegistryConfig();
 * registry.setAddress("10.20.130.230:9090");
 * registry.setUsername("aaa");
 * registry.setPassword("bbb");
 *
 * // 服务提供者协议配置
 * ProtocolConfig protocol = new ProtocolConfig();
 * protocol.setName("dubbo");
 * protocol.setPort(12345);
 * protocol.setThreads(200);
 *
 * // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
 *
 * // 服务提供者暴露服务配置
 * ServiceConfig<XxxService> service = new ServiceConfig<XxxService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
 * service.setApplication(application);
 * service.setRegistry(registry); // 多个注册中心可以用setRegistries()
 * service.setProtocol(protocol); // 多个协议可以用setProtocols()
 * service.setInterface(XxxService.class);
 * service.setRef(xxxService);
 * service.setVersion("1.0.0");
 *
 * // 暴露及注册服务
 * service.export();
 *
 *
 * // 当前应用配置
 * ApplicationConfig application = new ApplicationConfig();
 * application.setName("yyy");
 *
 * // 连接注册中心配置
 * RegistryConfig registry = new RegistryConfig();
 * registry.setAddress("10.20.130.230:9090");
 * registry.setUsername("aaa");
 * registry.setPassword("bbb");
 *
 * // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
 *
 * // 引用远程服务
 * ReferenceConfig<XxxService> reference = new ReferenceConfig<XxxService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
 * reference.setApplication(application);
 * reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
 * reference.setInterface(XxxService.class);
 * reference.setVersion("1.0.0");
 *
 * // 和本地bean一样使用xxxService
 * XxxService xxxService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
 */

//开启dubbo
//@EnableDubbo
@EnableDubbo(scanBasePackages = "com.hq.bamllserviceprovider.impl")
@EnableHystrix
@SpringBootApplication
public class BamllServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BamllServiceProviderApplication.class, args);
    }

}
