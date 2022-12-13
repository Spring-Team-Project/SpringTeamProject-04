package com.bitc.springteamproject1209.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class UpdateInfoDto {
    private int memIdx;
    private String memEmail;
    private String memId;
    private String memPwd;
    private String memAddr;
    private String memDeletedYn;
    private String memCreateDate;
    private List<ReviewDto> reContents;
}

