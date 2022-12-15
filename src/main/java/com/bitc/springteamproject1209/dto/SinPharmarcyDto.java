package com.bitc.springteamproject1209.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class SinPharmarcyDto {

    private String dutyAddr;
    private String dutyName;
    private String dutyTel1;
    private String dutyTime1c;
    private String dutyTime1s;
    private String dutyTime2c;
    private String dutyTime2s;
    private String dutyTime3c;
    private String dutyTime3s;
    private String dutyTime4c;
    private String dutyTime4s;
    private String dutyTime5c;
    private String dutyTime5s;
    private String dutyTime6c;
    private String dutyTime6s;
    private String hpid;
    private String postCdn1;
    private String postCdn2;
//    idx
    private String rnum;
//    위도
    private String wgs84Lat;
//    경도
    private String wgs84Lon;

}
