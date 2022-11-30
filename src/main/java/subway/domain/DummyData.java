package subway.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import subway.constant.Constant;

public enum DummyData {
    TWO("2호선", "교대역-강남역-역삼역"),
    THREE("3호선", "교대역-남부터미널역-양재역-매봉역"),
    SINBUNDAN("신분당선", "강남역-양재역-양재시민의숲역");

    private String lineName;
    private String stationNames;

    DummyData(String lineName, String stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public static List<String> findAllStationsName() {
        return Arrays.stream(DummyData.values())
                .map(DummyData::findStationsName)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> findAllLinesName() {
        return Arrays.stream(DummyData.values())
                .map(dummyData -> dummyData.getLineName())
                .collect(Collectors.toList());
    }

    public List<String> findStationsName() {
        return Arrays.stream(stationNames.split(Constant.STATION_NAME_SPLIT_REGEX))
                .collect(Collectors.toList());
    }

    public String getLineName() {
        return lineName;
    }
}
