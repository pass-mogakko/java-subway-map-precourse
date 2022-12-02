package subway.domain.station;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StationRepositoryTest {

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
}