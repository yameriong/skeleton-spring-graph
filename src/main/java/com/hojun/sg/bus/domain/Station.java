package com.hojun.sg.bus.domain;

import lombok.*;

import java.util.UUID;

@Builder(access = AccessLevel.PRIVATE)
public record Station(String id, String address, String city, String state, String stationName) {
    public static Station of(String address, String city, String state, String stationName){
        return Station.builder()
                .id(UUID.randomUUID().toString())
                .address(address)
                .city(city)
                .state(state)
                .stationName(stationName)
                .build();
    }
}
