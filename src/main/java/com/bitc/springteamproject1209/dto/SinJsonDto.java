package com.bitc.springteamproject1209.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor // 는 모든 필드를 넣어주는 생성자 생성. 생성자 생성 당시에만 데이터를 넣어주게끔 유도하기위해 사용
@NoArgsConstructor // 는 기본생성자 생성. 의존성 주입이나 이외의 메모리할상이나 참조값 전달등 다양하게 사용하기 위해 주로 사용
public class SinJsonDto {

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
