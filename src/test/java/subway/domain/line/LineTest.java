package subway.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {

    @DisplayName("이름 일치여부 출력 테스트 - True")
    @ValueSource(strings = {"1호선", "2호선", "9호선", "수인분당선"})
    @ParameterizedTest
     void nameEqualsTrueTest(String name) {
        assertThat(new Line(name).nameEquals(name)).isEqualTo(true);
    }

    @DisplayName("이름 일치여부 출력 테스트 - False")
    @ValueSource(strings = {"1호선", "수인분당선", " ", "", "111호선!!", "111", "abc"})
    @ParameterizedTest
     void nameEqualsFalseTest(String name) {
        assertThat(new Line("111호선").nameEquals(name)).isEqualTo(false);
    }

}