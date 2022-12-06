package subway.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class LineRepositoryTest {

    @Test
    void 예외_존재하지_않는_노선_get() {
        assertThatThrownBy(() -> LineRepository.getLine("폐쇄역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_중복된_노선() {
        Line line = new Line("3호선");

        assertThatThrownBy(() -> LineRepository.addLine(line))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_존재하지_않는_노선_삭제() {
        assertThatThrownBy(() -> LineRepository.deleteLineByName("aa"))
                .isInstanceOf((IllegalArgumentException.class));
    }
}