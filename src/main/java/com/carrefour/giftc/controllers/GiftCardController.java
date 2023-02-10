package com.carrefour.giftc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiftCardController {
    Logger logger = LoggerFactory.getLogger(GiftCardController.class);
    @Value("${app.message}")
    private String message;
    @GetMapping("/hello")
    public String hello(){

        logger.info("POS request from {}", 1234);
        return message;
    }
}
