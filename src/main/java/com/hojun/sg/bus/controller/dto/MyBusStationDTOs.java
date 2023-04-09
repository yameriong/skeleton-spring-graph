package com.hojun.sg.bus.controller.dto;

import com.hojun.sg.bus.domain.MyBusStationInfos;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record MyBusStationDTOs (List<MyBusStationDTO> myBusStations){
    public static MyBusStationDTOs of(MyBusStationInfos myBusStations){
        return MyBusStationDTOs.builder()
                .myBusStations(myBusStations.convertDTO())
                .build();
    }
}
