package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@SequenceGenerator(name = "STATION_SEQ_GEN", sequenceName = "STATION_SEQ")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATION_SEQ_GEN")
    Long id;
    String address;
    String city;
    String state;
    String stationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @Builder
    public Station(Long id, String address, String city, String state, String stationName, User user) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.stationName = stationName;
        this.user = user;
    }
}
