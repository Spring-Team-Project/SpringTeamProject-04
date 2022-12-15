package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.SinPharmarcyDto;

import java.util.List;
import java.util.Map;


public interface SinJsonService {
    List<Object> getJsonData() throws Exception;

    List<SinPharmarcyDto> XmlToJson() throws Exception;
}
