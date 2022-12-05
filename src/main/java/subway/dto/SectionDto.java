package subway.dto;

import java.util.List;

public class SectionDto {

    private final String lineName;
    private final List<String> stationNames;

    public SectionDto(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStationName() {
        return stationNames;
    }
}
