package subway.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static subway.domain.line.LineCommand.*;

class LineCommandTest {

    @DisplayName("노선 관리 페이지 입력값을 Command로 변환 테스트")
    @Test
    void convertToCommandTest() {
        assertThat(LineCommand.convertToCommand("1")).isEqualTo(ADD_LINE);
        assertThat(LineCommand.convertToCommand("2")).isEqualTo(DELETE_LINE);
        assertThat(LineCommand.convertToCommand("3")).isEqualTo(SHOW_LINE);
        assertThat(LineCommand.convertToCommand("B")).isEqualTo(BACK);
    }

    @DisplayName("메인페이지 입력값을 Command로 변환 테스트 - null")
    @ValueSource(strings = {"0", "5", "일", "", "Q"})
    @ParameterizedTest
    void convertToCommandNullTest(String input) {
        assertThat(LineCommand.convertToCommand(input)).isEqualTo(null);
    }

}