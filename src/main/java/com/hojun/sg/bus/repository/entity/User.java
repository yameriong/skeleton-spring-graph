package com.hojun.sg.bus.repository.entity;

import com.hojun.sg.bus.domain.StationInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "myUser")
@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GEN")
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    @OneToOne
    Station myRouteLocation;
    @OneToMany(mappedBy = "user")
    List<Station> myFavoritesStations;

    @Builder
    public User(Long id, String firstName, String lastName, String phoneNumber, String email, Station myRouteLocation, List<Station> myFavoritesStations) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.myRouteLocation = myRouteLocation;
        this.myFavoritesStations = myFavoritesStations;
    }

    public List<StationInfo> convertStationInfos() {
        return myFavoritesStations.stream().map(StationInfo::of).toList();
    }
}
