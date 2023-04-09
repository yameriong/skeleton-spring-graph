package com.hojun.sg.bus.mock;

import com.hojun.sg.bus.domain.MyBusStationInfo;
import com.hojun.sg.bus.domain.MyBusStationInfos;
import com.hojun.sg.bus.domain.Station;

import java.util.List;

public class MockDataLoader {
    public static final MyBusStationInfos ALL_USER_BUS_INFO = MyBusStationInfos.of(ofJun(), ofYang());
    public static final MyBusStationInfo HOJUN_BUS_INFO = ofJun();
    public static final MyBusStationInfo YANG_BUS_INFO = ofYang();

    public static MyBusStationInfo ofYang() {
        return MyBusStationInfo.of("yang", "yang", "010-1113-2221",
                "eke3@hose.com", inchonStationOf(), List.of());
    }

    public static MyBusStationInfo ofJun() {
        return MyBusStationInfo.of("hojun", "choi", "010-333-2221",
                "eke3@hose.com", seoulStationOf(), List.of(seoulStationOf(), inchonStationOf()));
    }

    private static Station seoulStationOf() {
        return Station.of("112-2", "jung-gu", "seoul", "서울역");
    }

    private static Station inchonStationOf() {
        return Station.of("999-2", "san-gok", "inchon", "산곡역");
    }
}
