package subway.domain.section;

import subway.domain.station.Station;
import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Section {
    private final List<Station> stations;

    public Section() {
        this.stations = new ArrayList<>();
    }

    public void addSection(Station station, final int order) {
        validateStationDuplication(station);
        stations.add(order, station);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addTerminus(Station upBound, Station downBound) {
        stations.add(upBound);
        stations.add(downBound);
    }

    public void deleteSection(String stationName) {
        validateExistSectionStation(stationName);
        stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    private void validateExistSectionStation(String stationName) {
        Station inputStation = new Station(stationName);
        if (!hasDuplication(inputStation)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION_STATION);
        }
    }

    private void validateStationDuplication(Station station) {
        if (hasDuplication(station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXISTING_SECTION_STATION);
        }
    }

    private boolean hasDuplication(Station inputStation) {
        return stations.stream()
                .anyMatch(station ->
                        Objects.equals(station.getName(), inputStation.getName()));
    }

    public List<String> getStations() {
        List<String> stationGroup = new ArrayList<>();
        for (Station station : stations) {
            stationGroup.add(station.getName());
        }
        return stationGroup;
    }
}


