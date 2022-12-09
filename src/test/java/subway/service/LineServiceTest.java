package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.line.LineService;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;

class LineServiceTest {

    private static final LineService lineService = LineService.getInstance();

    private static Stream<String> generateInitialLinesStream() {
        return LineRepository.lines()
                .stream().map(Line::getName)
                .collect(Collectors.toList())
                .stream();
    }

    @ParameterizedTest
    @ValueSource(strings = {"역", "1", "", "@"})
    void 노선등록_정해진_길이_미만_이름_예외발생(String invalidName) {
        assertThatThrownBy(() -> lineService.addLine(new LineDTO(invalidName), new FinalStationsDTO("강남역", "양재역")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateInitialLinesStream")
    void 노선등록_이미_등록된_이름_예외발생(String duplicatedName) {
        assertThatThrownBy(() -> lineService.addLine(new LineDTO(duplicatedName), new FinalStationsDTO("강남역", "양재역")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선등록_존재하지_않는_종점역_이름_예외발생() {
        assertThatThrownBy(() -> lineService.addLine(new LineDTO("테스트노선이름"), new FinalStationsDTO("역이름", "강남역")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> lineService.addLine(new LineDTO("테스트노선이름"), new FinalStationsDTO("강남역", "역이름")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 노선삭제_존재하지_않는_노선_이름_예외발생() {
        assertThatThrownBy(() -> lineService.deleteLine(new LineDTO("테스트노선이름")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}