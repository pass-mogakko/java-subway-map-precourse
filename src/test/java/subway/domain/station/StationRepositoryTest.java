package subway.domain.station;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @BeforeEach
    void setUp() {
        StationRepository.clear();
    }

    @Test
    void 역_등록하기() {
        assertThatThrownBy(() -> StationRepository.findStationByName("충정로역")).isInstanceOf(IllegalArgumentException.class);
        StationRepository.addStation("충정로역");
        assertThatCode(() -> StationRepository.findStationByName("충정로역")).doesNotThrowAnyException();
    }

    @Test
    void 역_삭제하기() {
        assertThatCode(() -> StationRepository.findStationByName("강남역")).doesNotThrowAnyException();
        StationRepository.deleteStation("강남역");
        assertThatThrownBy(() -> StationRepository.findStationByName("강남역")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지하철_노선_초기_데이터_설정() {
        assertThatCode(() -> StationRepository.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("역삼역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("양재시민의숲역")).doesNotThrowAnyException();
        assertThatCode(() -> StationRepository.findStationByName("매봉역")).doesNotThrowAnyException();
    }

    @Test
    void 이미_등록된_역_등록하기() {
        StationRepository.addStation("충정로역");
        assertThatThrownBy(() -> StationRepository.addStation("충정로역")).isInstanceOf(IllegalArgumentException.class);
    }
}