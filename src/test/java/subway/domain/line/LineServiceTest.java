package subway.domain.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.StationRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static subway.domain.util.ErrorCode.*;

class LineServiceTest {
    private final LineService lineService = new LineService();

    @BeforeEach
    void setUp() {
        StationRepository.setUp();
        LineRepository.setUp();
    }

    @DisplayName("노선 추가하기 테스트")
    @Test
    void addLineTest() {
        // when
        lineService.addLine("1호선", "강남역", "매봉역");
        lineService.addLine("9호선", "강남역", "매봉역");
        lineService.addLine("4호선", "강남역", "매봉역");

        // then
        assertThat(LineRepository.findByName("1호선")).isNotNull();
        assertThat(LineRepository.findByName("9호선")).isNotNull();
        assertThat(LineRepository.findByName("4호선")).isNotNull();
    }

    @DisplayName("노선 추가하기 - 예외 테스트")
    @Test
    void addLineExceptionTest() {
        assertThatThrownBy(() -> lineService.addLine("2호선", "강남역", "매봉역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_LINE_NAME.getMessage());
        assertThatThrownBy(() -> lineService.addLine("7호선", "없는역", "매봉역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(STATION_NOT_FOUND.getMessage());
        assertThatThrownBy(() -> lineService.addLine("4호선", "강남역", "없는역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(STATION_NOT_FOUND.getMessage());
    }

    @DisplayName("노선 조회하기 테스트")
    @Test
    void showAllLinesTest() {
        assertThat(lineService.showAllLines())
                .isNotNull()
                .isInstanceOf(String.class)
                .contains("[INFO] ", "2호선", "3호선", "신분당선");
    }

    @Test
    void deleteLine() {
    }
}