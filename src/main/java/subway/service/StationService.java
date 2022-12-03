package subway.service;

import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.StationDTO;

public class StationService {

    private StationService() { }

    public static List<StationDTO> getAllStations() {
        return StationRepository.stations()
                .stream()
                .map(station -> new StationDTO(station.getName()))
                .collect(Collectors.toList());
    }

    public static void addStation(StationDTO station) {
        String name = station.getName();
        validateStationName(name);
        StationRepository.addStation(new Station(name));
    }

    private static void validateStationName(String name) {
        // TODO 입력 에러 메시지 상수화
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException("역 이름은 최소 2글자 이상이어야 합니다.");
        }
        if (StationRepository.findStationOrNullByName(name) != null) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
    }
}
