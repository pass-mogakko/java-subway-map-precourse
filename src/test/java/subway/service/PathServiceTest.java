package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// TODO 테스트 메소드명 일괄 한글로 변경
class PathServiceTest {

    @DisplayName("구간 추가: 존재하지 않는 노선 이름이면 예외 발생")
    @Test
    void insertPathWithNullLineName() {
        assertThatThrownBy(() -> PathService.insertPath("테스트노선이름", "강남역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 존재하지 않는 역 이름이면 예외 발생")
    @Test
    void insertPathWithNullStationName() {
        assertThatThrownBy(() -> PathService.insertPath("2호선", "테스트역이름", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 이미 노선에 포함된 역 이름이면 예외 발생")
    @Test
    void insertPathWithExistingStationName() {
        assertThatThrownBy(() -> PathService.insertPath("2호선", "강남역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구간 추가: 해당 노선의 역 개수보다 큰 순서 값이면 예외 발생")
    @Test
    void insertPathWithOverIndex() {
        assertThatThrownBy(() -> PathService.insertPath("2호선", "매봉역", 100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}