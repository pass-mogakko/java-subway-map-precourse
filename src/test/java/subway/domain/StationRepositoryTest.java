package subway.domain;


import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @Test
    void 지하철_노선_초기_데이터_설정() {
        StationRepository stationRepository = new StationRepository();
        List<String> allStationNameDummy = stationRepository.stations()
                .stream()
                .map(station -> station.getName())
                .collect(Collectors.toList());

        Assertions.assertThat(allStationNameDummy)
                .contains("교대역", "강남역", "역삼역", "양재역", "양재시민의숲역", "매봉역");
    }
}