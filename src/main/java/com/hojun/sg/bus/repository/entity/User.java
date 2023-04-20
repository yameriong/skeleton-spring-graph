package com.hojun.sg.bus.repository.entity;

import com.hojun.sg.bus.domain.StationInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Many-to-many associations should not be made, but specific details are included as examples
 */
@Entity
@Getter
@Table(name = "myUser")
@Builder(toBuilder = true)
@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GEN")
    @Column(name = "user_id")
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    @ManyToOne
    @JoinColumn(name = "station_id")
    Station myRouteLocation;
    @OneToMany(mappedBy = "user")
    List<MyFavoriteStation> myFavoriteStations = new ArrayList<>();

    public List<StationInfo> convertStationInfos() {
        return myFavoriteStations.stream().map(MyFavoriteStation::getStation).map(StationInfo::of).toList();
    }
}
