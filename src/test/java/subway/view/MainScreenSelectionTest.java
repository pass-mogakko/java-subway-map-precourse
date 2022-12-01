package subway.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MainScreenSelectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "Q"})
    void 메인_화면_정상적인_입력(String input) {
        assertThatCode(() -> MainScreenSelection.validate(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "5", "-1", "q"})
    void 메인_화면_비정상적인_입력_예외처리하기(String input) {
        assertThatThrownBy(() -> MainScreenSelection.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}