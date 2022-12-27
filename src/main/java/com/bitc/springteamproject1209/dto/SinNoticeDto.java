package com.bitc.springteamproject1209.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SinNoticeDto {

    private String noticeHcHeader;
    private String noticeHcContents;
    private String noticePmHeader;
    private String noticePmContents;
}
