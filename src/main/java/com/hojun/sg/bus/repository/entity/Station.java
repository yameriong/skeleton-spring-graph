package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(name = "STATION_SEQ_GEN", sequenceName = "STATION_SEQ")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Station {
    @Id
    @Column(name = "station_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATION_SEQ_GEN")
    Long id;
    String address;
    String city;
    String state;
    String stationName;
}
