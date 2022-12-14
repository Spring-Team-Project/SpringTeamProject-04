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

    //    ?????? ?????? ?????????
    @RequestMapping("/pmlist")
    public ModelAndView PMListView() throws Exception {
        ModelAndView mv = new ModelAndView("LeePMList");

        List<LeePMDto> PMDBList = leePMService.PMDBList();
        List<SinNoticeDto> Notice = sinWdbService.getNotice();

        mv.addObject("PMDBList", PMDBList);
        mv.addObject("Notice", Notice);

        return mv;
    }

    // ?????? ?????? ?????? ??????
    @PostMapping("/noticeEdit1")
    public void editNotice(@RequestParam("noticePmHeader") String title, @RequestParam("noticePmContents") String main) throws Exception{


        SinNoticeDto sinNoticeDto = new SinNoticeDto();

        sinNoticeDto.setNoticePmHeader(title);
        sinNoticeDto.setNoticePmContents(main);

        leePMService.updateNotice(sinNoticeDto);

    }

    //    ??????????????? ?????? ??????
    @GetMapping("pmlist/filter")
    public List<LeePMDto> PMFilterList(@RequestParam(value = "userSearchWord") String userSearchWord, @RequestParam(value = "telCode") String telCode) throws Exception {

        return leePMService.PMFilterList(userSearchWord, telCode);
    }

    //    ???????????????
    @GetMapping("/pmlist/telfilter")
    public List<LeePMDto> PMTelFilter(@RequestParam(value = "telCode") String telcode) throws Exception {

        return leePMService.PMTelFilter(telcode);
    }

//        ?????? ????????? ???
    @GetMapping("/pmlist/{idx}")
    public ModelAndView openPMDetail(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("LeePMDetail");


        LeePMDto leePMDto = leePMService.selectPMDetail(idx);
        List<ReviewDto> detailReview = leePMService.selectPMReview(idx);


        mv.addObject("reviewIdx",idx);
        mv.addObject("PMReview", detailReview);
        mv.addObject("PMDetail", leePMDto);

        return mv;
    }

    //  ?????? ??????
    @PostMapping("/pmreviewInsert")
    public ResponseEntity<?> reviewInsert(@RequestParam("idx")int idx, ReviewDto reviewDto) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        try {
            leePMService.insertUserReview(reviewDto);
            System.out.println("?????? ?????? ??????");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("?????? ?????? ??????");
        }
        try {
            leePMService.insertStarAvg(idx);
            System.out.println("?????? ?????? ?????? ??????");
        }catch (Exception e){
            System.out.println("?????? ?????? ?????? ??????");
            e.printStackTrace();
        }


        headers.setLocation(URI.create("/pmlist/"+idx));


        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

//    ------------------------------------------------------------------------
//    select box ????????? thymeleaf ??????
    @ModelAttribute("LeeTelCode")
    public List<LeeTelCode> leeTelCodes(){

        List<LeeTelCode> leeTelCodes = new ArrayList<>();
        leeTelCodes.add(new LeeTelCode("02-", "??????"));
        leeTelCodes.add(new LeeTelCode("032-", "??????"));
        leeTelCodes.add(new LeeTelCode("042-", "??????"));
        leeTelCodes.add(new LeeTelCode("051-", "??????"));
        leeTelCodes.add(new LeeTelCode("052-", "??????"));
        leeTelCodes.add(new LeeTelCode("053-", "??????"));
        leeTelCodes.add(new LeeTelCode("062-", "??????"));
        leeTelCodes.add(new LeeTelCode("064-", "??????"));
        leeTelCodes.add(new LeeTelCode("031-", "??????"));
        leeTelCodes.add(new LeeTelCode("033-", "??????"));
        leeTelCodes.add(new LeeTelCode("041-", "??????"));
        leeTelCodes.add(new LeeTelCode("043-", "??????"));
        leeTelCodes.add(new LeeTelCode("054-", "??????"));
        leeTelCodes.add(new LeeTelCode("055-", "??????"));
        leeTelCodes.add(new LeeTelCode("061-", "??????"));
        leeTelCodes.add(new LeeTelCode("063-", "??????"));

        return leeTelCodes;


    }

}













