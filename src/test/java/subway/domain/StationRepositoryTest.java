package subway.domain;


import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @BeforeEach
    void setUp() {
        StationRepository stationRepository = new StationRepository();
    }

    @Test
    void 지하철_노선_초기_데이터_설정() {
        List<String> allStationNameDummy = StationRepository.stations()
                .stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());

        Assertions.assertThat(allStationNameDummy)
                .containsExactly("2호선", "3호선", "신분당선");
    }
}