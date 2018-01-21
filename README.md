###Features

- spring boot web 项目 访问Jsp页面(tomcat服务器)
- 可以单元测试service层
- 可以不需要单独启动web服务器才能测试
- 把web项目启来，再去测单元测试(并行)
- git 地址 :  https://github.com/opensourceteams/n_100007_spring-boot-junit-test-service
- url : http://localhost:8080/jsp/helloMessage?message=a


```shell
mvn spring-boot:run
```
## 配置类

```java
package com.opensourceteam.modules.configuration.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@Configuration
@ComponentScan("com.opensourceteam")
public class CustomMVCConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

}

```
## 服务层类

```java
package com.opensourceteam.modules.business.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 开发人:刘文
 * 日期:  2018/1/21.
 * 功能描述:
 */
@Service
public class HelloService {
    Logger logger = LoggerFactory.getLogger(HelloService.class) ;
    public void hello(){
        logger.info("[HelloService.hello] call " + new Date());
    }
}

```

## 服务层单元测试

```java
package com.opensourceteam.modules.business.sample.service;

import com.opensourceteam.modules.configuration.spring.CustomMVCConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 开发人:刘文
 * 日期:  2018/1/21.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomMVCConfiguration.class)
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void hello() throws Exception {
        helloService.hello();
    }

}
```
















