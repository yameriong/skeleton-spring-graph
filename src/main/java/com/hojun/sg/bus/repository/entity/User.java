package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "myUser")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class User {
    @Id
    String id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    @OneToOne
    Station myRouteLocation;
    @OneToMany
    @JoinColumn(name = "bus_id")
    List<Station> myFavoritesStations;

    @Builder
    public User(String firstName, String lastName, String phoneNumber, String email, Station myRouteLocation, List<Station> myFavoritesStations) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.myRouteLocation = myRouteLocation;
        this.myFavoritesStations = myFavoritesStations;
    }
}
