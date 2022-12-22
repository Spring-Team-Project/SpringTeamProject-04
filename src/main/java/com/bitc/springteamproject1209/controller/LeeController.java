package com.bitc.springteamproject1209.controller;

import com.bitc.springteamproject1209.dto.*;
import com.bitc.springteamproject1209.mapper.SinWdbMapper;
import com.bitc.springteamproject1209.service.LeeMemService;
import com.bitc.springteamproject1209.service.LeePMService;
import com.bitc.springteamproject1209.service.LeePharmacyFullDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
@RestController
@Controller
public class LeeController {
    @Autowired
    private LeePharmacyFullDataService leePharmacyFullDataService;

    @Autowired
    private LeeMemService leeMemService;

    @Autowired
    private LeePMService leePMService;

    @Value("${openApi.endPoint}")
    private String endPointUrl;

    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Autowired
    private SinWdbMapper sinWdbService;

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
    public ResponseEntity<?> updateMember(MemberDto memberDto) throws Exception {
        leeMemService.updateInfo(memberDto);

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create("/myPage"));


        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @RequestMapping("/publicHealthDetail")
    public String LeePublicHealthDetail() throws Exception {
        return "LeePublicHealthDetail";
    }

    @RequestMapping("/pharmacyDetail")
    public String LeePharmacyDetail() throws Exception {
        return "LeePharmacyDetail";
    }

    //    약국 전체 리스트
    @RequestMapping("/pmlist")
    public ModelAndView PMListView() throws Exception {
        ModelAndView mv = new ModelAndView("LeePMList");

        List<LeePMDto> PMDBList = leePMService.PMDBList();

        mv.addObject("PMDBList", PMDBList);

        return mv;
    }

    //    지역번호와 검색 모두
    @GetMapping("pmlist/filter")
    public List<LeePMDto> PMFilterList(@RequestParam(value = "userSearchWord") String userSearchWord, @RequestParam(value = "telCode") String telCode) throws Exception {

        return leePMService.PMFilterList(userSearchWord, telCode);
    }

    //    지역번호만
    @GetMapping("/pmlist/telfilter")
    public List<LeePMDto> PMTelFilter(@RequestParam(value = "telCode") String telcode) throws Exception {

        return leePMService.PMTelFilter(telcode);
    }

//        상세 페이지 뷰
    @GetMapping("/pmlist/{idx}")
    public ModelAndView openPMDetail(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("LeePMDetail");


        LeePMDto leePMDto = leePMService.selectPMDetail(idx);
        List<ReviewDto> detailReview = leePMService.selectPMReview(idx);


        mv.addObject("PMReview", detailReview);
        mv.addObject("PMDetail", leePMDto);

        return mv;
    }

    //  리뷰 작성
    @PostMapping("/reviewInsert2")
    public void reviewInsert2(ReviewDto reviewDto) throws Exception {

        try {
            leePMService.insertUserReview(reviewDto);
            System.out.println("리뷰 작성 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("리뷰 작성 실패");
        }
    }

//    ------------------------------------------------------------------------
//    select box 채우기 thymeleaf 방식
    @ModelAttribute("LeeTelCode")
    public List<LeeTelCode> leeTelCodes(){

        List<LeeTelCode> leeTelCodes = new ArrayList<>();
        leeTelCodes.add(new LeeTelCode("02-", "서울"));
        leeTelCodes.add(new LeeTelCode("032-", "인천"));
        leeTelCodes.add(new LeeTelCode("042-", "대전"));
        leeTelCodes.add(new LeeTelCode("051-", "부산"));
        leeTelCodes.add(new LeeTelCode("052-", "울산"));
        leeTelCodes.add(new LeeTelCode("053-", "대구"));
        leeTelCodes.add(new LeeTelCode("062-", "광주"));
        leeTelCodes.add(new LeeTelCode("064-", "제주"));
        leeTelCodes.add(new LeeTelCode("031-", "경기"));
        leeTelCodes.add(new LeeTelCode("033-", "강원"));
        leeTelCodes.add(new LeeTelCode("041-", "충남"));
        leeTelCodes.add(new LeeTelCode("043-", "충북"));
        leeTelCodes.add(new LeeTelCode("054-", "경북"));
        leeTelCodes.add(new LeeTelCode("055-", "경남"));
        leeTelCodes.add(new LeeTelCode("061-", "전남"));
        leeTelCodes.add(new LeeTelCode("063-", "전북"));

        return leeTelCodes;


    }

}













