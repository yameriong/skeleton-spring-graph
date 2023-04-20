package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(name = "FAVORITE_STATION_SEQ_GEN", sequenceName = "FAVORITE_STATION_SEQ")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class MyFavoriteStation {
    @Id
    @Column(name = "favorite_station_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FAVORITE_STATION_SEQ")
    Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "station_id")
    Station station;
}
