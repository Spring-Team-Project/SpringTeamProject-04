package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class LeePharmacyFullDataServiceImpl implements LeePharmacyFullDataService{

    @Override
    public List<LeePharmacyFullDataItemDto> getItemList() throws Exception{
        JAXBContext jc = JAXBContext.newInstance(LeePharmacyFullDataDto.class);
        Unmarshaller um = jc.createUnmarshaller();

        LeePharmacyFullDataDto fullData = (LeePharmacyFullDataDto) um.unmarshal(new File("C://java505//LeePharmacy.xml"));

        LeePharmacyFullDataHeaderDto header = fullData.getHeader();
        LeePharmacyFullDataBodyDto body = fullData.getBody();
        LeePharmacyFullDataItemsDto items = body.getItems();
//    사용자가 필요로 하는 데이터만 출력
        List<LeePharmacyFullDataItemDto> itemList = items.getItemList();

        return itemList;

    }

    @Override
    public List<LeePharmacyFullDataItemDto> getItemListUrl(String strUrl) throws Exception {
        List<LeePharmacyFullDataItemDto> itemList = null;
        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(LeePharmacyFullDataDto.class);
            Unmarshaller um = jc.createUnmarshaller();

            LeePharmacyFullDataDto fullData = (LeePharmacyFullDataDto) um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (urlConn != null) { urlConn.disconnect(); }
        }

        return itemList;


    }

    @Override
    public List<LeePharmacyFullDataItemDto> getItemListUrlJson(String strUrl) throws Exception {
        List<LeePharmacyFullDataItemDto> itemList = null;
        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(LeePharmacyFullDataDto.class);
            Unmarshaller um = jc.createUnmarshaller();

            LeePharmacyFullDataDto fullData = (LeePharmacyFullDataDto) um.unmarshal(url);
            itemList = fullData.getBody().getItems().getItemList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (urlConn != null) { urlConn.disconnect(); }
        }

        return itemList;
    }
}
