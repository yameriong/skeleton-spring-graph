package com.hojun.sg.bus.domain;

import com.hojun.sg.bus.controller.dto.MyBusStationDTO;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder(access = AccessLevel.PRIVATE)
public record MyBusStationInfo(String id, String firstName, String lastName, String phoneNumber, String email,
                              Station myRouteLocation, List<Station> myFavoritesStations) {
    public static final MyBusStationInfo EMPTY = MyBusStationInfo.builder().build();

    public static MyBusStationInfo of(String firstName, String lastName, String phoneNumber, String email,
                                      Station myRouteLocation, List<Station> myFavoritesStations){
        return MyBusStationInfo.builder()
                .id(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .email(email)
                .myRouteLocation(myRouteLocation)
                .myFavoritesStations(myFavoritesStations)
                .build();
    }


    public MyBusStationDTO toDTO(){
        return MyBusStationDTO.of(this);
    }
}
