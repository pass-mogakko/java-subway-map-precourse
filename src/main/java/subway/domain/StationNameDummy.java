package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StationNameDummy {
    TWO("2호선"),
    THREE("3호선"),
    SHINBUNDANG("신분당선");

    private final String stationName;

    StationNameDummy(String stationName) {
        this.stationName = stationName;
    }

    public static List<String> findAllStationNameDummy() {
        return Arrays.stream(StationNameDummy.values())
                .map(StationNameDummy::getStationName)
                .collect(Collectors.toList());
    }

    public String getStationName() {
        return stationName;
    }
}
