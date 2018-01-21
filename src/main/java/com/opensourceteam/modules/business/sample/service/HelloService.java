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
