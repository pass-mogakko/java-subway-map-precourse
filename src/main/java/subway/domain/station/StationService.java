package subway.domain.station;

import subway.domain.util.MessageFactory;

import static subway.domain.util.ErrorCode.*;

class StationService {
    private static final MessageFactory messageFactory = new MessageFactory();

    public void addStation(String name) {
        validateNewName(name);
        StationRepository.save(new Station(name));
    }

    public void deleteStation(String stationName) {
        validatePresentStation(stationName);
        StationRepository.deleteStation(stationName);
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
    }

}
