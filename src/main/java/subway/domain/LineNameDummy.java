package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LineNameDummy {
    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    YANGJAE("양재역"),
    YANGJAESIMIN("양재시민의숲역"),
    MAEBONG("매봉역");

    private final String lineName;

    LineNameDummy(String lineName) {
        this.lineName = lineName;
    }

    public static List<String> findAllLineNameDummy() {
        return Arrays.stream(LineNameDummy.values())
                .map(LineNameDummy::getLineName)
                .collect(Collectors.toList());
    }

    public String getLineName() {
        return lineName;
    }
}
