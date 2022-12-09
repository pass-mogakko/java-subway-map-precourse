package subway.repository.dto;

import java.util.List;

public class RouteMapDTO {

    private String lineName;
    private List<String> stationNames;

    public RouteMapDTO(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public String getLineName() {
        return this.lineName;
    }

    public List<String> getStationNames() {
        return this.stationNames;
    }


}
