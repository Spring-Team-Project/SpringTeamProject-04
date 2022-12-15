package com.bitc.springteamproject1209.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "items")
public class LeePharmacyFullDataItemsDto {
    private List<LeePharmacyFullDataItemDto> itemList;

    @XmlElement(name = "item")
    public List<LeePharmacyFullDataItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<LeePharmacyFullDataItemDto> itemList) {
        this.itemList = itemList;
    }
}
