package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.*;
import com.bitc.springteamproject1209.mapper.SinWdbMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinWdbServiceImpl implements SinWdbService {


    //--------------------------------------------------------------------------------------------------------------


    //    페이지의 SQL 작업 맵퍼
    @Autowired
    private SinWdbMapper sinWdbMapper;

//--------------------------------------------------------------------------------------------------------------

    //    Json 데이터 서비스
    @Autowired
    private SinJsonService sinJsonService;

//--------------------------------------------------------------------------------------------------------------

    //    아이디 중복 체크
    @Override
    public int overlappedID(String userId) throws Exception {


        int idCheck = sinWdbMapper.idCheck(userId);
        return idCheck;
    }

    //    이메일 중복 체크
    @Override
    public int overlappedEmail(String userEmail) throws Exception {
        int emailCheck = sinWdbMapper.emailCheck(userEmail);
        return emailCheck;
    }

//--------------------------------------------------------------------------------------------------------------

    //    회원테이블 신규 회원 데이터 입력
    @Override
    public void insertUser(SinRegistDto sinRegistDto) throws Exception {

        sinWdbMapper.insertUser(sinRegistDto);

    }

//--------------------------------------------------------------------------------------------------------------


    //  DB 에서 가져오는 보건소 리스트

    @Override
    public List<SinHCDto> HCDBList() throws Exception {


        List<SinHCDto> allData = sinWdbMapper.receiveHCDBList();
        List<SinHCDto> pagingPerData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            pagingPerData.add(allData.get(i));

        }
        return pagingPerData;
    }

    // 세미 페이징
    @Override
    public List<SinHCDto> HCDBList(int HCPageNum) throws Exception {

        int nextData, totalData, endData, startData;

        List<SinHCDto> allData = sinWdbMapper.receiveHCDBList();
        List<SinHCDto> pagingPerData = new ArrayList<>();

        startData = HCPageNum;
        endData = (HCPageNum * 10) + 1;

        nextData = (HCPageNum * 10) - 10;


        totalData = 241;


        if (endData > totalData) {
            endData = totalData;

        } else {
            endData = (HCPageNum * 10);
        }
        if (nextData > totalData) {
            nextData = totalData - 1;
        } else {
            nextData = (HCPageNum * 10) - 10;
        }

        if (HCPageNum == 0) {
            HCPageNum = 1;
        }


        if (HCPageNum == 1) {

            for (int i = 0; i < 10; i++) {
                pagingPerData.add(allData.get(i));

            }
            return pagingPerData;

        } else if (HCPageNum > 1) {
            for (int i = nextData; i < endData; i++) {
                pagingPerData.add(allData.get(i));

            }
            return pagingPerData;
        }

        return allData;
    }

    //    검색 및 필터링
    @Override
    public List<SinHCDto> HCFilterList(String userSearchWord, String telCode) throws Exception {
        return sinWdbMapper.receiveHCDBDoubleList(userSearchWord, telCode);
    }

    //  지역번호로 필터링
    @Override
    public List<SinHCDto> HCTelFilter(String telCode) throws Exception {


        return sinWdbMapper.receiveHCDBTelCodeList(telCode);
    }

    //  보건소 상세 페이지
    @Override
    public SinHCDto selectHCDetail(int idx) throws Exception {


        return sinWdbMapper.getHCDetailDto(idx);
    }


    // 상세 페이지 내 리뷰 작성
    @Override
    public void insertUserReview(ReviewDto reviewDto) throws Exception {
        sinWdbMapper.insertUserReview(reviewDto);
    }

    //  상세 페이지 내 리뷰 불러오기
    @Override
    public List<ReviewDto> selectHCReview(int idx) throws Exception {
        return sinWdbMapper.getHCReview(idx);
    }

    //  상세 페이지 내 근처 약국 찾기
    @Override
    public List<LeePharmacyFullDataItemDto> findNearPharmacy(String addr) throws Exception {
        String mapSido = addr.substring(0, 2);


        return sinWdbMapper.nearPhamFind(mapSido);
    }

    @Override
    public void insertStarAvg(int idx) throws Exception {
        sinWdbMapper.insertStarAvg(idx);
    }


//--------------------------------------------------------------------------------------------------------------

////////////////////////////////// API 리스트 메인 뿌리기 (현재 폐기)/////////////////////////////////////////////////

    //    초기 뷰
    @Override
    public List<SinJsonDto> HCMainList() throws Exception {

        //        리턴 해줄 dto 리스트
        List<SinJsonDto> sendSinJsonDto = new ArrayList<>();
//        변환할 object 리스트
        List<Object> receiveJson = sinJsonService.getJsonData();

        try {
            for (int i = 0; i < receiveJson.size(); i++) {
//            하나하나 꺼내기
                JSONObject mapJson = (JSONObject) receiveJson.get(i);
                String sido = mapJson.get("시도").toString();
                String sigungu = mapJson.get("시군구").toString();
                String medicalType = mapJson.get("보건기관 유형").toString();
                String medicalName = mapJson.get("보건기관명").toString();
                String postCode = mapJson.get("우편번호").toString();
                String medicalAddr = mapJson.get("주소").toString();
                String eupmyeondong = mapJson.get("읍면동명").toString();
                String doseo = mapJson.get("도서지역여부").toString();
                String tel = mapJson.get("대표전화번호").toString();

                SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                sendSinJsonDto.add(sinJsonDto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendSinJsonDto;
    }


//--------------------------------------------------------------------------------------------------------------


////////////////////////////////// API 리스트 뿌리기 (현재 폐기)/////////////////////////////////////////////////

    //    Api로 불러온 Json 데이터 Dto 변수 맵핑
    @Override
    public List<SinJsonDto> HCList(String UWord, String telCode) throws Exception {

//        리턴 해줄 dto 리스트
        List<SinJsonDto> sendSinJsonDto = new ArrayList<>();
//        변환할 object 리스트
        List<Object> receiveJson = sinJsonService.getJsonData();


        try {
            for (int i = 0; i < receiveJson.size(); i++) {

//            하나하나 꺼내기
                JSONObject mapJson = (JSONObject) receiveJson.get(i);

//               지역번호를 가지고 검색을 했을때
                if (UWord != null && telCode != null) {
                    String allTel = mapJson.get("대표전화번호").toString();
                    String allAddr = mapJson.get("주소").toString();
                    String compare = allTel.substring(0, 3);
                    String compare2 = allTel.substring(0, 2);

                    if (compare2.equals(telCode) && allAddr.contains(UWord)) {
                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();

                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                        sendSinJsonDto.add(sinJsonDto);


                    } else if (compare.equals(telCode) && allAddr.contains(UWord)) {
                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();

                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                        sendSinJsonDto.add(sinJsonDto);
                    }

                }

//                검색만 했을때
                if (UWord != null && (telCode == null || telCode == "")) {
                    String allAddr = mapJson.get("주소").toString();

                    if (allAddr.contains(UWord)) {
                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();


                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                        sendSinJsonDto.add(sinJsonDto);
                    } else {
                        continue;
                    }
                }

//                지역번호만 있을때
                if (UWord == null && telCode != null) {
                    String allTel = mapJson.get("대표전화번호").toString();
                    String compare = allTel.substring(0, 3);
                    String compare2 = allTel.substring(0, 2);

                    if (compare2.equals(telCode)) {
                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();

                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                        sendSinJsonDto.add(sinJsonDto);

                    } else if (compare.equals(telCode)) {
                        String sido = mapJson.get("시도").toString();
                        String sigungu = mapJson.get("시군구").toString();
                        String medicalType = mapJson.get("보건기관 유형").toString();
                        String medicalName = mapJson.get("보건기관명").toString();
                        String postCode = mapJson.get("우편번호").toString();
                        String medicalAddr = mapJson.get("주소").toString();
                        String eupmyeondong = mapJson.get("읍면동명").toString();
                        String doseo = mapJson.get("도서지역여부").toString();
                        String tel = mapJson.get("대표전화번호").toString();

                        SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                        sendSinJsonDto.add(sinJsonDto);
                    }


                }
//                둘다 null 일 때
                if (UWord == "" && telCode == "") {

                    String sido = mapJson.get("시도").toString();
                    String sigungu = mapJson.get("시군구").toString();
                    String medicalType = mapJson.get("보건기관 유형").toString();
                    String medicalName = mapJson.get("보건기관명").toString();
                    String postCode = mapJson.get("우편번호").toString();
                    String medicalAddr = mapJson.get("주소").toString();
                    String eupmyeondong = mapJson.get("읍면동명").toString();
                    String doseo = mapJson.get("도서지역여부").toString();
                    String tel = mapJson.get("대표전화번호").toString();

                    SinJsonDto sinJsonDto = new SinJsonDto(sido, sigungu, medicalType, medicalName, postCode, medicalAddr, eupmyeondong, doseo, tel);

                    sendSinJsonDto.add(sinJsonDto);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendSinJsonDto;
    }


////////////////////////////////// API 리스트 뿌리기 (현재 폐기)/////////////////////////////////////////////////


}
