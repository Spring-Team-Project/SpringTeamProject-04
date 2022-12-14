package com.bitc.springteamproject1209.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class UpdateInfoController {
    @GetMapping("updateForm")
    public String updateForm() {
        return "updateForm";
    }
}
