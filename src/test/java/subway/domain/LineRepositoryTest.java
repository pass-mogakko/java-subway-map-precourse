package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;



class LineRepositoryTest {

    @Test
    void 예외_존재하지_않는_노선_get() {
        assertThatThrownBy(() -> LineRepository.getLine("폐쇄역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_중복된_노선() {
        assertThatThrownBy(() -> LineRepository.addLine("2호선", "삼척역", "동해역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_존재하지_않는_노선_삭제() {
        assertThatThrownBy(() -> LineRepository.deleteLineByName("aa"))
                .isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void 삭제_노선() {
        LineRepository.deleteLineByName("2호선");

        System.out.println(LineRepository.lines());
        System.out.println(RouteRepository.routes());
    }
}