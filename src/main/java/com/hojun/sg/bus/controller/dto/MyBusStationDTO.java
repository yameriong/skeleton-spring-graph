package com.hojun.sg.bus.controller.dto;

import com.hojun.sg.bus.domain.MyBusStationInfo;
import com.hojun.sg.bus.domain.Station;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record MyBusStationDTO(String firstName, String lastName, String phoneNumber, String email,
                              Station myRouteLocation, List<Station> myFavoritesStations) {

    public static MyBusStationDTO of(MyBusStationInfo person) {
        return MyBusStationDTO.builder()
                .firstName(person.firstName())
                .lastName(person.lastName())
                .email(person.email())
                .myRouteLocation(person.myRouteLocation())
                .myFavoritesStations(person.myFavoritesStations())
                .build();
    }
}
