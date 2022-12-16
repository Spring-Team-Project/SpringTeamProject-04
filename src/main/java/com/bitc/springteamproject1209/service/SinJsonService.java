package com.bitc.springteamproject1209.service;

import java.util.List;


public interface SinJsonService {
//    보건소 리스트 불러오기
    List<Object> getJsonData() throws Exception;


//    약국 DB 저장
    void getItemListUrl(String strUrl);
}
