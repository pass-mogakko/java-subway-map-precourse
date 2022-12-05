package subway.domain.station;

import subway.domain.util.MessageFactory;

import static subway.domain.util.ErrorCode.DUPLICATE_STATION_NAME;

class StationService {
    private static final MessageFactory messageFactory = new MessageFactory();

    public void addStation(String name) {
        validateNewName(name);
        StationRepository.save(new Station(name));
    }

    private void validateNewName(String name) {
        Station station = StationRepository.findByName(name);
        if (station != null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_STATION_NAME));
        }
    }

    private Station isPresentStation(String name) {
        Station station = StationRepository.findByName(name);
        if (station == null) {
            throw new IllegalArgumentException();
        }
        return station;
    }
}
