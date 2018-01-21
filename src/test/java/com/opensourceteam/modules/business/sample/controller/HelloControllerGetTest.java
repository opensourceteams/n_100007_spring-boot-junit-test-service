package com.opensourceteam.modules.business.sample.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloController.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = {"com.opensourceteam.business","com.opensourceteam"})
@EnableWebMvc
public class HelloControllerGetTest {

    Logger logger = LoggerFactory.getLogger(HelloControllerGetTest.class);



    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() throws Exception {


        String result = this.restTemplate.getForObject("http://localhost:" + port + "/hello?message=中国",
                String.class);
        logger.info("result:{}" , result);
    }

}