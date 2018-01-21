package com.opensourceteam.modules.business.sample.controller;

import com.opensourceteam.modules.business.sample.vo.HelloMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.Map;

/**
 * 开发人:刘文
 * 日期:  2017/11/25.
 * 功能描述:
 */
@Controller
@RequestMapping("/jsp")
public class HelloJspController {

    Logger logger = LoggerFactory.getLogger(HelloJspController.class);

    @RequestMapping("/hello")
    String hello(String message) {

        logger.info("[/jsp/hello]测试/jsp/hello 信息  == 4");

        return "hello";
    }

    @RequestMapping("/helloMessage")
    String helloMessage(Map<String, Object> model) {
        logger.info("[/jsp/hello]测试/jsp/hello2 信息  == 4");
         model.put("message","后台的消息_" + new Date()) ;
        return "helloMessage";
    }


    @RequestMapping("/helloMessageParam")
    String helloMessageParam(Map<String, Object> model, @ModelAttribute HelloMessage helloMessage) {
        logger.info("[/jsp/hello]测试/jsp/hello2 信息  == 4");
        model.put("message","后台的消息_" + new Date()) ;
        model.put("helloMessage",helloMessage) ;
        return "helloMessageParam";
    }




}
