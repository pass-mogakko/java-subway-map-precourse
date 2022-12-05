package subway.domain.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static subway.domain.global.SystemCommand.*;

class SystemCommandTest {

    @DisplayName("메인페이지 입력값을 Command로 변환 테스트")
    @Test
    void convertToCommandTest() {
        assertThat(SystemCommand.convertToCommand("1")).isEqualTo(STATION_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("2")).isEqualTo(LINE_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("3")).isEqualTo(SECTION_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("4")).isEqualTo(SHOW_LINE_SECTION_MAP);
        assertThat(SystemCommand.convertToCommand("Q")).isEqualTo(QUIT);
    }

    @DisplayName("메인페이지 입력값을 Command로 변환 테스트 - null")
    @ValueSource(strings = {"0", "5", "일", "", "B"})
    @ParameterizedTest
    void convertToCommandNullTest(String input) {
        assertThat(SystemCommand.convertToCommand(input)).isEqualTo(null);
    }

}