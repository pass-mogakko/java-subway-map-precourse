package subway.service;

import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.StationDTO;

// TODO 입력 에러 메시지 상수화 or validate 클래스 분리
public class StationService {

    private StationService() {
    }

    public static List<StationDTO> getAllStations() {
        return StationRepository.stations()
                .stream()
                .map(station -> new StationDTO(station.getName()))
                .collect(Collectors.toList());
    }

    public static void addStation(StationDTO station) {
        String name = station.getName();
        validateNameToCreate(name);
        StationRepository.addStation(new Station(name));
    }

    private static void validateNameToCreate(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException("역 이름은 최소 2글자 이상이어야 합니다.");
        }
        if (StationRepository.findStationOrNullByName(name) != null) {
            throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
        }
    }

    public static void deleteStation(StationDTO station) {
        String name = station.getName();
        validateNameToDelete(name);
        // TODO boolean값 필요?
        StationRepository.deleteStation(name);
    }

    private static void validateNameToDelete(String name) {
        if (StationRepository.findStationOrNullByName(name) == null) {
            throw new IllegalArgumentException("삭제할 역이 존재하지 않습니다.");
        }
        if (PathRepository.hasStation(name)) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
