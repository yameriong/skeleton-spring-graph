package com.hojun.sg.bus.application;

import com.hojun.sg.bus.repository.StationRepository;
import com.hojun.sg.bus.repository.UserRepository;
import com.hojun.sg.bus.repository.entity.Station;
import com.hojun.sg.bus.repository.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@SpringBootTest
@Transactional
class MyBusServiceTest {
    private MyBusService myBusService;
    private UserRepository userRepository;
    private StationRepository stationRepository;
    private int count = 1000;

    @Autowired
    MyBusServiceTest(MyBusService myBusService, UserRepository userRepository, StationRepository stationRepository) {
        this.myBusService = myBusService;
        this.userRepository = userRepository;
        this.stationRepository = stationRepository;
    }

    @BeforeEach
    void setUp() {
        var stations = LongStream.range(1, count + 1)
                .mapToObj(number -> Station.builder()
                        .stationName("서울역")
                        .state("seoul")
                        .city("jung-gu")
                        .address("112-2")
                        .build())
                .collect(Collectors.toList());
        var users = LongStream.range(1, count + 1)
                .mapToObj(number -> User.builder()
                        .firstName("hojun")
                        .lastName("choi")
                        .email("hojun@hose.com")
                        .phoneNumber("010-333-2221")
                        .myRouteLocation(givenList_whenSeriesLengthChosen_shouldReturnRandomSeries(stations, 1).get(0))
                        .build())
                .collect(Collectors.toList());
        System.out.println("---------------insert---------------");
        stationRepository.saveAll(stations);
        userRepository.saveAll(users);
    }

    @Test
    void getMyBusStationInfoByAllUser() {
        System.out.println("---------------findAll---------------");
        var users = myBusService.getMyBusStationInfoByAllUser();
    }

    private static <T> List<T> givenList_whenSeriesLengthChosen_shouldReturnRandomSeries(List<T> givenList, int size) {
        Collections.shuffle(givenList);
        return givenList.subList(0, size);
    }
}