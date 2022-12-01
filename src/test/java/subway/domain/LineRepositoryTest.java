package subway.domain;


import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import subway.domain.line.LineRepository;

class LineRepositoryTest {

    @Test
    void 지하철_역_초기_데이터_설정() {
        assertThatCode(() -> LineRepository.findLineByName("2호선")).doesNotThrowAnyException();
        assertThatCode(() -> LineRepository.findLineByName("3호선")).doesNotThrowAnyException();
        assertThatCode(() -> LineRepository.findLineByName("2호선")).doesNotThrowAnyException();
    }
}