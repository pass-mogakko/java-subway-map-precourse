package subway.domain.line;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @Test
    void 지하철_노선_초기_데이터_설정() {
        assertThatCode(() -> LineRepository.findLineByName("2호선")).doesNotThrowAnyException();
        assertThatCode(() -> LineRepository.findLineByName("3호선")).doesNotThrowAnyException();
        assertThatCode(() -> LineRepository.findLineByName("2호선")).doesNotThrowAnyException();
    }

    @Test
    void 노선_등록하기() {
        assertThatThrownBy(() -> LineRepository.findLineByName("4호선")).isInstanceOf(IllegalArgumentException.class);
        LineRepository.addLine("4호선");
        assertThatCode(() -> LineRepository.findLineByName("4호선")).doesNotThrowAnyException();
    }

}