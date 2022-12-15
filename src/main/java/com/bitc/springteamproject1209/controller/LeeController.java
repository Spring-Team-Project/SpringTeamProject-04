package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.service.LeePharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LeeController {
    @Autowired
    private LeePharmacyFullDataService leePharmacyFullDataService;

    @Value("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService")
    private String endPointUrl;

    @Value("TR5gWXa5e%2Bn58lzKE7i%2BvC5ooqifY%2FqT%2BHC6gBiw9mjxECIJANH0OuZYS968l64bGC37cfWoPV6WFwv6TGv98g%3D%3D")
    private String serviceKey;

    @RequestMapping("/updateInfo")
    public String LeeUpdateInfo() throws Exception {
        return "LeeUpdateInfo";
    }

    @RequestMapping("/publicHealthDetail")
    public String LeePublicHealthDetail() throws Exception {
        return "LeePublicHealthDetail";
    }

    @RequestMapping(value = "/pharmacyList", method = RequestMethod.GET)
    public String LeePharmacyList() throws Exception {
        return "LeePharmacyList";
    }

    @ResponseBody
    @RequestMapping(value = "/pharmacyList", method = RequestMethod.POST)
    public Object getFullDataAjax() throws Exception {

        String reqService = "/getParmacyFullDown";
        String service = "?serviceKey=";
        String option1 = "&pageNo=";
        String option2 = "&numOfRows=";

        String url = endPointUrl + reqService + service + serviceKey + option1 + 1 + option2 + 10;

        List<LeePharmacyFullDataItemDto> pharmacyDatas = leePharmacyFullDataService.getItemListUrl(url);

        return pharmacyDatas;
    }


}
