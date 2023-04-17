package com.hojun.sg.bus.domain;

import com.hojun.sg.bus.controller.dto.MyBusStationDTO;
import com.hojun.sg.bus.repository.entity.User;
import lombok.AccessLevel;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder(access = AccessLevel.PRIVATE)
public record MyBusStationInfo(String id, String firstName, String lastName, String phoneNumber, String email,
                               StationInfo myRouteLocation, List<StationInfo> myFavoritesStations) {
    public static final MyBusStationInfo EMPTY = MyBusStationInfo.builder().build();

    public static MyBusStationInfo of(String firstName, String lastName, String phoneNumber, String email,
                                      StationInfo myRouteLocation, List<StationInfo> myFavoritesStations){
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

    public static MyBusStationInfo ofUser(User user){
        return MyBusStationInfo.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .myRouteLocation(StationInfo.of(user.getMyRouteLocation()))
                .myFavoritesStations(user.convertStationInfos())
                .build();
    }


    public MyBusStationDTO toDTO(){
        return MyBusStationDTO.of(this);
    }
}
