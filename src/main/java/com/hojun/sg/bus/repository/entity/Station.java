package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Station {
    @Id
    String id;
    String address;
    String city;
    String state;
    String stationName;

    @Builder
    public Station(String address, String city, String state, String stationName) {
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.city = city;
        this.state = state;
        this.stationName = stationName;
    }
}
