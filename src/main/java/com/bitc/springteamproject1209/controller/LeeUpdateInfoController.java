package com.bitc.springteamproject1209.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LeeUpdateInfoController {
    @GetMapping("updateForm")
    public String updateForm() {
        return "updateForm";
    }
}
