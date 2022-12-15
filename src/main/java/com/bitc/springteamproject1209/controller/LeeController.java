package com.bitc.springteamproject1209.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LeeController {
    @RequestMapping("/updateInfo")
    public String LeeUpdateInfo() throws Exception {
        return "LeeUpdateInfo";
    }

    @RequestMapping("/pharmacyList")
    public String LeePharmacyList() throws Exception {
        return "LeePharmacyList";
    }

    @RequestMapping("/publicHealthDetail")
    public String LeePublicHealthDetail() throws Exception {
        return "LeePublicHealthDetail";
    }


}
