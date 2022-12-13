package com.bitc.springteamproject1209.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonDto {

    @JsonProperty(value = "시도")
    private String sido;
    @JsonProperty(value = "시군구")
    private String sigungu;
    @JsonProperty(value = "보건기관 유형")
    private String medicalType;
    @JsonProperty(value = "보건기관명")
    private String medicalName;
    @JsonProperty(value = "우편번호")
    private String postCode;
    @JsonProperty(value = "주소")
    private String medicalAddr;
    @JsonProperty(value = "읍면동명")
    private String eupmyeondong;
    @JsonProperty(value = "도서지역여부")
    private String doseo;
    @JsonProperty(value = "대표전화번호")
    private String tel;
}
