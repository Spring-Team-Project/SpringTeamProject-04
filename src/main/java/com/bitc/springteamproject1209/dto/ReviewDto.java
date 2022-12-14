package com.bitc.springteamproject1209.dto;


import lombok.Data;

@Data
public class ReviewDto {
    private int reIdx;
    private String reId;
    private String reMdName;
    private String reContents;
    private String reCreateDate;
    private String reDeletedYn;
    private String reUpdateDate;
    private String reMdAddr;
    private int reNum;
    private int reStar;
    private String condition;
    private String searchText;

}
