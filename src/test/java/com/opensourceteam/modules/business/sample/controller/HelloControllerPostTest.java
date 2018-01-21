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
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloController.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = {"com.opensourceteam.business","com.opensourceteam"})
@EnableWebMvc
@PropertySource({"application.properties"})
public class HelloControllerPostTest {

    Logger logger = LoggerFactory.getLogger(HelloControllerPostTest.class);



    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() throws Exception {



        String url = "http://localhost:" + port + "/hello";

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("message","小明");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        HttpEntity<String> response = this.restTemplate.postForEntity(url ,request,String.class) ;

        logger.info("result:{}" , response.getBody());
    }

}