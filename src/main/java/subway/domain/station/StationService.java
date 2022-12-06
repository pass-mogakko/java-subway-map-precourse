package subway.domain.station;

import subway.domain.section.LineSection;
import subway.domain.section.LineSectionRepository;
import subway.domain.util.MessageFactory;

import java.util.List;

import static subway.domain.util.ErrorCode.*;

class StationService {
    private static final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        StationRepository.setUp();
    }

    public void addStation(String name) {
        validateNewName(name);
        StationRepository.save(new Station(name));
    }

    public void deleteStation(String stationName) {
        validatePresentStation(stationName);
        StationRepository.deleteStation(stationName);
    }

    public String showAllStations() {
        List<Station> stations = StationRepository.findAll();

        StringBuilder stringBuilder = new StringBuilder();
        for (Station station : stations) {
            String stationInfo = messageFactory.makeInfo(station.getName());
            stringBuilder.append(stationInfo);
        }
        return stringBuilder.toString();
    }

    private void validateNewName(String name) {
        Station station = StationRepository.findByName(name);
        if (station != null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_STATION_NAME));
        }
    }

    private void validatePresentStation(String name) {
        Station station = StationRepository.findByName(name);
        if (station == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_FOUND));
        }

        LineSection lineSection = LineSectionRepository.findByStation(station);
        if (lineSection != null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_REGISTERED));
        }
    }

}
