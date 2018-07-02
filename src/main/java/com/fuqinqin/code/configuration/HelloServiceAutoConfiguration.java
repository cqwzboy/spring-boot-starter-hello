package com.fuqinqin.code.configuration;

import com.fuqinqin.code.config.HelloServiceProperties;
import com.fuqinqin.code.service.HelloService;
import com.fuqinqin.code.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(){
        HelloService helloService = new HelloServiceImpl();
        ((HelloServiceImpl) helloService).setMsg(helloServiceProperties.getMsg());
        return helloService;
    }

}
