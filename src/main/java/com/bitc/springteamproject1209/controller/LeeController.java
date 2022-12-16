package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.service.LeeMemService;
import com.bitc.springteamproject1209.service.LeePharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LeeController {
    @Autowired
    private LeePharmacyFullDataService leePharmacyFullDataService;

    @Autowired
    private LeeMemService leeMemService;

    @Value("${openApi.endPoint}")
    private String endPointUrl;

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @RequestMapping(value = "/pharmacyListFile", method = RequestMethod.GET)
    public ModelAndView getFullData() throws Exception {
        ModelAndView mv = new ModelAndView("LeePharmacyListFile");

        List<LeePharmacyFullDataItemDto> itemList = leePharmacyFullDataService.getItemList();
        mv.addObject("pharmacyDatas", itemList);

        return mv;
    }

    @RequestMapping(value = "/pharmacyList", method = RequestMethod.GET)
    public String viewFullData() throws Exception {

        return "LeePharmacyList";
    }

    @ResponseBody
    @RequestMapping(value = "/pharmacyList", method = RequestMethod.POST)
    public Object getFullDataAjax(@RequestParam int page, int count) throws Exception {

        String reqService = "/getParmacyFullDown";
        String service = "?serviceKey=";
        String option1 = "&pageNo=";
        String option2 = "&numOfRows=";

        String url = endPointUrl + reqService + service + serviceKey + option1 + page + option2 + count;

        List<LeePharmacyFullDataItemDto> pharmacyDatas = leePharmacyFullDataService.getItemListUrl(url);

        return pharmacyDatas;
    }

    @RequestMapping("/updateInfo")
    public ModelAndView LeeUpdateInfo() throws Exception {
        ModelAndView mv = new ModelAndView("LeeUpdateInfo");
        List<MemberDto> memberDto = leeMemService.selectMemInfo();
        mv.addObject("member", memberDto);
        return mv;
    }
    @RequestMapping("/updateMember")
    public String updateMember(MemberDto memberDto) throws Exception{
        leeMemService.updateInfo(memberDto);
        return "main";
    }

    @RequestMapping("/publicHealthDetail")
    public String LeePublicHealthDetail() throws Exception {
        return "LeePublicHealthDetail";
    }


}
