package subway.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineManageSelectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "B"})
    void 노선관리_화면_정상적인_입력(String input) {
        assertThatCode(() -> LineManageSelection.validate(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "4", "-1", "b"})
    void 노선관리_화면_비정상적인_입력_예외처리하기(String input) {
        assertThatThrownBy(() -> LineManageSelection.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}