package com.hojun.sg.bus.domain;

import com.hojun.sg.bus.controller.dto.MyBusStationDTO;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record MyBusStationInfos(List<MyBusStationInfo> myBusStationInfos) {
    public static final MyBusStationInfos EMPTY = defaultOf();

    public static MyBusStationInfos of(MyBusStationInfo... stationInfos) {
        return MyBusStationInfos.builder()
                .myBusStationInfos(List.of(stationInfos))
                .build();
    }

    public List<MyBusStationDTO> convertDTO() {
        return myBusStationInfos().stream().map(MyBusStationInfo::toDTO).toList();
    }

    public MyBusStationInfo hasInfo(String id) {
        return isEmpty()
                ? MyBusStationInfo.EMPTY
                : myBusStationInfos()
                .stream()
                .filter(i -> id.equals(i.id()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("data not found. id=" + id));
    }

    public boolean isEmpty() {
        return null == myBusStationInfos
                || myBusStationInfos.isEmpty();
    }


    private static MyBusStationInfos defaultOf() {
        return MyBusStationInfos.builder()
                .myBusStationInfos(Collections.emptyList())
                .build();
    }
}
