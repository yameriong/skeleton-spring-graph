package com.hojun.sg.bus.application;

import com.hojun.sg.aop.Timer;
import com.hojun.sg.bus.domain.MyBusStationInfo;
import com.hojun.sg.bus.domain.MyBusStationInfos;
import com.hojun.sg.bus.mock.MockDataLoader;
import com.hojun.sg.bus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyBusService {
    UserRepository userRepository;

    @Timer
    @Transactional(readOnly = true)
    public MyBusStationInfos getMyBusStationInfoByAllUser() {
        return new MyBusStationInfos(userRepository.findAll().stream().map(MyBusStationInfo::ofUser).toList());
    }

    @Timer
    @Transactional(readOnly = true)
    public MyBusStationInfo getMyBusStationInfoByPersonId(Long id) {
        return userRepository.findById(id).map(MyBusStationInfo::ofUser).orElseGet(() -> MyBusStationInfo.EMPTY);
    }
}
