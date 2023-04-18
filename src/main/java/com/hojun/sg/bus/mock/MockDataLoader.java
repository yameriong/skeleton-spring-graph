package com.hojun.sg.bus.mock;

import com.hojun.sg.bus.domain.MyBusStationInfo;
import com.hojun.sg.bus.domain.MyBusStationInfos;
import com.hojun.sg.bus.domain.StationInfo;
import com.hojun.sg.bus.repository.StationRepository;
import com.hojun.sg.bus.repository.UserRepository;
import com.hojun.sg.bus.repository.entity.Station;
import com.hojun.sg.bus.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class MockDataLoader implements CommandLineRunner {

    UserRepository userRepository;
    StationRepository stationRepository;
    public static MyBusStationInfo ofYang() {
        return MyBusStationInfo.of("yang", "yang", "010-1113-2221",
                "yang@hose.com", inchonStationOf(), List.of());
    }

    public static MyBusStationInfo ofJun() {
        return MyBusStationInfo.of("hojun", "choi", "010-333-2221",
                "hojun@hose.com", seoulStationOf(), List.of(seoulStationOf(), inchonStationOf()));
    }

    private static StationInfo seoulStationOf() {
        return StationInfo.of("112-2", "jung-gu", "seoul", "서울역");
    }

    private static StationInfo inchonStationOf() {
        return StationInfo.of("999-2", "san-gok", "inchon", "산곡역");
    }

    @Override
    public void run(String... args) throws Exception {

        var seoulSt = Station.builder()
                .stationName("서울역")
                .state("seoul")
                .city("jung-gu")
                .address("112-2")
                .build();
        var sanGokSt = Station.builder()
                .stationName("산곡역")
                .state("inchon")
                .city("san-gok")
                .address("999-2")
                .build();
        var hojunUser = User.builder()
                .firstName("hojun")
                .lastName("choi")
                .email("hojun@hose.com")
                .phoneNumber("010-333-2221")
                .myRouteLocation(sanGokSt)
                .build();
        var yangUser = User.builder()
                .firstName("yang")
                .lastName("yang")
                .email("yang@hose.com")
                .phoneNumber("010-1113-2221")
                .myRouteLocation(seoulSt)
                .build();
        stationRepository.save(seoulSt);
        stationRepository.save(sanGokSt);
        userRepository.save(hojunUser);
        userRepository.save(yangUser);
    }
}
