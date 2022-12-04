package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// TODO 테스트 메소드명 일괄 한글로 변경
class PathServiceTest {

    @DisplayName("구간 추가: 존재하지 않는 노선 이름이면 예외 발생")
    @Test
    void insertStationToPathWithNullLineName() {
        assertThatThrownBy(() -> PathService.insertStationToPath("테스트노선이름", "강남역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 존재하지 않는 역 이름이면 예외 발생")
    @Test
    void insertStationToPathWithNullStationName() {
        assertThatThrownBy(() -> PathService.insertStationToPath("2호선", "테스트역이름", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 이미 노선에 포함된 역 이름이면 예외 발생")
    @Test
    void insertStationToPathWithExistingStationName() {
        assertThatThrownBy(() -> PathService.insertStationToPath("3호선", "교대역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 해당 노선의 역 개수보다 큰 순서 값이면 예외 발생")
    @Test
    void insertStationToPathWithOverIndex() {
        assertThatThrownBy(() -> PathService.insertStationToPath("2호선", "매봉역", 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 삭제: 존재하지 않는 노선 이름이면 예외 발생")
    @Test
    void deleteStationFromNullPath() {
        assertThatThrownBy(() -> PathService.deleteStationFromPath("테스트노선이름", "매봉역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 삭제: 해당 노선에 존재하지 않는 역 이름이면 예외 발생")
    @Test
    void deleteNullStationFromPath() {
        assertThatThrownBy(() -> PathService.deleteStationFromPath("2호선", "테스트역이름"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 삭제: 역의 개수가 2개 뿐인 경우 예외 발생")
    @Test
    void deleteStationFromUnderSizePath() {
        PathService.deleteStationFromPath("2호선", "강남역");
        assertThatThrownBy(() -> PathService.deleteStationFromPath("2호선", "강남역"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}