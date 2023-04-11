package com.hojun.sg.bus.application;

import com.hojun.sg.aop.Timer;
import com.hojun.sg.bus.domain.MyBusStationInfo;
import com.hojun.sg.bus.domain.MyBusStationInfos;
import com.hojun.sg.bus.mock.MockDataLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyBusService {
    @Timer
    @Transactional(readOnly = true)
    public MyBusStationInfos getMyBusStationInfoByAllUser() {
        return MockDataLoader.ALL_USER_BUS_INFO;
    }
    @Timer
    @Transactional(readOnly = true)
    public MyBusStationInfo getMyBusStationInfoByPersonId(String id) {
        return MockDataLoader.ALL_USER_BUS_INFO.hasInfo(id);
    }
}
