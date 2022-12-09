package subway.view.validator;

import subway.constants.ExceptionMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class Validator {

    public static void existentLine(String lineName) {
        if (StationRepository.findByStationName(lineName).isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_FOUND_STATION);
        }
    }

    public static void notExistentLine(String lineName) {
        if (!LineRepository.findLineByName(lineName).isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_INSERT_LINE);
        }
    }

    public static void existentStation(String stationName) {
        if (StationRepository.findByStationName(stationName).isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_FOUND_STATION);
        }
    }

    public static void notExistentStation(String stationName) {
        if (!StationRepository.findByStationName(stationName).isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.ALREADY_INSERT_STATION);
        }
    }

}
