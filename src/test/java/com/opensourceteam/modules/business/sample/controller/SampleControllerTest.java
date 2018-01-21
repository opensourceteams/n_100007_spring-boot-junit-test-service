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

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Run.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = {"com.opensourceteam.business","com.opensourceteam"})
@EnableWebMvc
public class SampleControllerTest {

    Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);



    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() throws Exception {
        String result = this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class);
        logger.info("result:{}" , result);
    }

}