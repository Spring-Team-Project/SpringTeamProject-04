package com.bitc.springteamproject1209.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ReviewDto {
    private int reIdx;
    private String reId;
    private String reMdName;
    private String reContents;
    private String reCreateDate;
    private String reDeletedYn;
    private String reUpdateDate;

}
