package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.StationService;
import subway.dto.StationDTO;

class StationServiceTest {

    private static final StationService stationService = StationService.getInstance();

    private static Stream<String> generateInitialStationsStream() {
        return StationRepository.stations()
                .stream().map(Station::getName)
                .collect(Collectors.toList())
                .stream();
    }

    @ParameterizedTest
    @ValueSource(strings = {"역", "1", "", "@"})
    void 역등록_정해진_길이_미만_이름_예외발생(String invalidName) {
        assertThatThrownBy(() -> stationService.addStation(new StationDTO(invalidName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateInitialStationsStream")
    void 역등록_이미_등록된_이름_예외발생(String duplicatedName) {
        assertThatThrownBy(() -> stationService.addStation(new StationDTO(duplicatedName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateInitialStationsStream")
    void 역삭제_노선에_등록된_역_이름_예외발생(String linedName) {
        assertThatThrownBy(() -> stationService.deleteStation(new StationDTO(linedName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 역삭제_존재하지_않는_역_이름_예외발생() {
        assertThatThrownBy(() -> stationService.deleteStation(new StationDTO("테스트역이름")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}