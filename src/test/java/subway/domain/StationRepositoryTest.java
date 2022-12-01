package subway.domain;


import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import subway.domain.station.StationRepository;

class StationRepositoryTest {

    @Test
    void 지하철_노선_초기_데이터_설정() {
        assertThatCode(() -> StationRepository.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("역삼역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("양재시민의숲역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("매봉역")).doesNotThrowAnyException();
    }
}