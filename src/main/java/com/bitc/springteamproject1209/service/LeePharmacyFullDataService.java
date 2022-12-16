package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;

import java.util.List;

public interface LeePharmacyFullDataService {

    List<LeePharmacyFullDataItemDto> getItemList() throws Exception;

    List<LeePharmacyFullDataItemDto> getItemListUrl(String url) throws Exception;

    List<LeePharmacyFullDataItemDto> getItemListUrlJson(String url) throws Exception;
}
