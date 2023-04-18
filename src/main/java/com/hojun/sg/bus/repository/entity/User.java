package com.hojun.sg.bus.repository.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
