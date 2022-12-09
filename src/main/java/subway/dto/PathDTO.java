package subway.dto;

import java.util.List;

public class PathDTO {
    private final String lineName;
    private final List<String> stationNames;

    public PathDTO(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
