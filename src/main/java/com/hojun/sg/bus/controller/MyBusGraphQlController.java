package com.hojun.sg.bus.controller;

import com.hojun.sg.bus.application.MyBusService;
import com.hojun.sg.bus.controller.dto.MyBusStationDTO;
import com.hojun.sg.bus.controller.dto.MyBusStationDTOs;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MyBusGraphQlController {
    MyBusService myBusService;

    /**
     * {
     *   findAll {
     *     myBusStations {
     *       firstName
     *       lastName
     *       phoneNumber
     *       email
     *       myRouteLocation {
     *         stationName
     *       }
     *       myFavoritesStations {
     *         stationName
     *       }
     *     }
     *   }
     * }
     * @return
     * {
     *   "data": {
     *     "findAll": {
     *       "myBusStations": [
     *         {
     *           "firstName": "hojun",
     *           "lastName": "choi",
     *           "phoneNumber": null,
     *           "email": "eke3@hose.com",
     *           "myRouteLocation": {
     *             "stationName": "서울역"
     *           },
     *           "myFavoritesStations": [
     *             {
     *               "stationName": "서울역"
     *             },
     *             {
     *               "stationName": "산곡역"
     *             }
     *           ]
     *         },
     *         {
     *           "firstName": "yang",
     *           "lastName": "yang",
     *           "phoneNumber": null,
     *           "email": "eke3@hose.com",
     *           "myRouteLocation": {
     *             "stationName": "산곡역"
     *           },
     *           "myFavoritesStations": []
     *         }
     *       ]
     *     }
     *   }
     * }
     */
    @QueryMapping
    public MyBusStationDTOs findAll(){
        return MyBusStationDTOs.of(myBusService.getMyBusStationInfoByAllUser());
    }

    /**
     * {
     *   getMyBusStationInfo(id: "003ba260-23a7-45ca-987c-0c8273cdadcb") {
     *     firstName
     *     lastName
     *     phoneNumber
     *     email
     *     myRouteLocation {
     *       stationName
     *     }
     *     myFavoritesStations {
     *       stationName
     *     }
     *   }
     * }
     * @param id
     * @return
     * {
     *   "data": {
     *     "getMyBusStationInfo": {
     *       "firstName": "hojun",
     *       "lastName": "choi",
     *       "phoneNumber": null,
     *       "email": "eke3@hose.com",
     *       "myRouteLocation": {
     *         "stationName": "서울역"
     *       },
     *       "myFavoritesStations": [
     *         {
     *           "stationName": "서울역"
     *         },
     *         {
     *           "stationName": "산곡역"
     *         }
     *       ]
     *     }
     *   }
     * }
     */
    @QueryMapping
    public MyBusStationDTO getMyBusStationInfo(@Argument Long id){
        return myBusService.getMyBusStationInfoByPersonId(id).toDTO();
    }
}
