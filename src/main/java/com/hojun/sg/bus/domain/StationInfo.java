package com.hojun.sg.bus.domain;

import lombok.*;

import java.util.UUID;

@Builder(access = AccessLevel.PRIVATE)
public record StationInfo(String id, String address, String city, String state, String stationName) {
    public static StationInfo of(String address, String city, String state, String stationName){
        return StationInfo.builder()
                .id(UUID.randomUUID().toString())
                .address(address)
                .city(city)
                .state(state)
                .stationName(stationName)
                .build();
    }
}
