package subway.dto;

import java.util.List;

public class PathDTO {

    private final String lineName;
    private final List<String> stations;

    public PathDTO(String lineName, List<String> stations) {
        this.lineName = lineName;
        this.stations = stations;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStations() {
        return stations;
    }
}
