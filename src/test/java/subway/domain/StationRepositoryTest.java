package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import subway.Constants;



class StationRepositoryTest {

    @Test
    void getStation() {
        assertThatThrownBy(() -> StationRepository.getStation("폐쇄역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_PREFIX);
    }
}