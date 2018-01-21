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