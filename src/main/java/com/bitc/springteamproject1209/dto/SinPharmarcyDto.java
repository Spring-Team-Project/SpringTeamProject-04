package com.bitc.springteamproject1209.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SinPharmarcyDto {

    private String dutyAddr;
    private String dutyName;
    private String dutyTel1;
    private String dutyTime1c;
    private String dutyTime1s;
    private String hpid;

//    idx
    private String rnum;
//    위도
    private String wgs84Lat;
//    경도
    private String wgs84Lon;

}
