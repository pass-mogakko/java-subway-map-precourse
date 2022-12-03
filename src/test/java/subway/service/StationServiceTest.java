package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.StationDTO;

class StationServiceTest {

    @DisplayName("역 등록: 역 이름이 정해진 길이 미만이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"역", "1", "", "@"})
    void addStationWithInvalidName(String invalidName) {
        assertThatThrownBy(() -> StationService.addStation(new StationDTO(invalidName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("역 등록: 이미 등록된 역 이름이면 예외 발생")
    @ParameterizedTest
    @MethodSource("generateInitialStationsStream")
    void addStationWithDuplicatedName(String duplicatedName) {
        assertThatThrownBy(() -> StationService.addStation(new StationDTO(duplicatedName)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> generateInitialStationsStream() {
        return StationRepository.stations()
                .stream().map(Station::getName)
                .collect(Collectors.toList())
                .stream();
    }
}