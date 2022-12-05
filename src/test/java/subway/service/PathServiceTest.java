package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PathServiceTest {

    @Test
    void 구간추가_존재하지_않는_노선_이름_예외발생() {
        assertThatThrownBy(() -> PathService.insertStationToPath("테스트노선이름", "강남역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간추가_존재하지_않는_역_이름_예외발생() {
        assertThatThrownBy(() -> PathService.insertStationToPath("2호선", "테스트역이름", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간추가_이미_노선에_포함된_역_이름_예외발생() {
        assertThatThrownBy(() -> PathService.insertStationToPath("3호선", "교대역", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간추가_노선의_역_개수보다_큰_순서값_예외발생() {
        assertThatThrownBy(() -> PathService.insertStationToPath("2호선", "매봉역", 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간삭제_존재하지_않는_노선_이름_예외발생() {
        assertThatThrownBy(() -> PathService.deleteStationFromPath("테스트노선이름", "매봉역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간삭제_노선에_존재하지_않는_역_이름_예외발생() {
        assertThatThrownBy(() -> PathService.deleteStationFromPath("2호선", "테스트역이름"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구간삭제_노선의_역_개수가_2개_예외발생() {
        PathService.deleteStationFromPath("2호선", "강남역");
        assertThatThrownBy(() -> PathService.deleteStationFromPath("2호선", "강남역"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}