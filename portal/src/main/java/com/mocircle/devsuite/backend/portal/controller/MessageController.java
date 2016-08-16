package com.mocircle.devsuite.backend.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @RequestMapping("/message")
    public String messagePage() {
        return "message";
    }

}
