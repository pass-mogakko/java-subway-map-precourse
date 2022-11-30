package subway.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Stations {

    private final List<Station> stations;

    public Stations(List<String> stationsName) {
        stations = stationsName.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public Stations() {
        stations = DummyData.findAllStationsName()
                .stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
