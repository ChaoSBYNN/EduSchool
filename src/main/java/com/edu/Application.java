package com.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Properties;

/**
 * @ClassName Application
 * @Descripion TODO
 * @Author ChaoS_Zhang t7_chaos@163.com
 * @Date 2021/4/18 下午4:54
 * @Version 1.0
 **/
@EnableAsync
@EnableCaching
@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//排除自动配置
@MapperScan("com.edu.dao.mapper")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // 本地部署翻墙时使用
//        proxySetter();
    }

    public static void proxySetter() {
        Properties props = System.getProperties();
        props.setProperty("socksProxyHost", "127.0.0.1");
        props.setProperty("socksProxyPort", "7980");
    }

}
