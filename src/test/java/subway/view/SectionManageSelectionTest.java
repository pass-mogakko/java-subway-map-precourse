package subway.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SectionManageSelectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "B"})
    void 구간관리_화면_정상적인_입력(String input) {
        assertThatCode(() -> SectionManageSelection.validate(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "0", "3", "-1", "b"})
    void 구간관리_비정상적인_입력_예외처리하기(String input) {
        assertThatThrownBy(() -> SectionManageSelection.validate(input)).isInstanceOf(IllegalArgumentException.class);
    }
}