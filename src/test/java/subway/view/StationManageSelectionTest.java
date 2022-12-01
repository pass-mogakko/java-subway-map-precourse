package subway.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StationManageSelectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "B"})
    void 역관리_화면_정상적인_입력(String input) {
        assertThatCode(() -> StationManageSelection.validate(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "4", "-1", "b"})
    void 역관리_화면_비정상적인_입력_예외처리하기(String input) {
        assertThatThrownBy(() -> StationManageSelection.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}