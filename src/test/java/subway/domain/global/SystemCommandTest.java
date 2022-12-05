package subway.domain.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

class SystemCommandTest {

    @DisplayName("메인페이지 입력값을 Command로 변환하기")
    @Test
    void convertToCommandTest() {
        assertThat(SystemCommand.convertToCommand("1")).isEqualTo(SystemCommand.STATION_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("2")).isEqualTo(SystemCommand.LINE_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("3")).isEqualTo(SystemCommand.SECTION_MANAGEMENT);
        assertThat(SystemCommand.convertToCommand("4")).isEqualTo(SystemCommand.SHOW_LINE_SECTION_MAP);
        assertThat(SystemCommand.convertToCommand("Q")).isEqualTo(SystemCommand.QUIT);
    }

    @DisplayName("메인페이지 입력값을 Command로 변환하기 - null")
    @ValueSource(strings = {"0", "5", "일", "", "B"})
    @ParameterizedTest
    void convertToCommandNullTest(String input) {
        assertThat(SystemCommand.convertToCommand(input)).isEqualTo(null);
    }
}