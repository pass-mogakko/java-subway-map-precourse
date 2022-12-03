package subway.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;

class LineServiceTest {

    private static Stream<String> generateInitialLinesStream() {
        return LineRepository.lines()
                .stream().map(Line::getName)
                .collect(Collectors.toList())
                .stream();
    }

    @DisplayName("노선 등록: 노선 이름이 정해진 길이 미만이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"역", "1", "", "@"})
    void addLineWithInvalidName(String invalidName) {
        assertThatThrownBy(() -> LineService.addLine(new LineDTO(invalidName), new FinalStationsDTO("강남역", "양재역")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선 등록: 이미 등록된 노선 이름이면 예외 발생")
    @ParameterizedTest
    @MethodSource("generateInitialLinesStream")
    void addLineWithDuplicatedName(String duplicatedName) {
        assertThatThrownBy(() -> LineService.addLine(new LineDTO(duplicatedName), new FinalStationsDTO("강남역", "양재역")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선 등록: 존재하지 않는 종점역 이름이면 예외 발생")
    @Test
    void addLineWithNullStations() {
        assertThatThrownBy(() -> LineService.addLine(new LineDTO("테스트노선이름"), new FinalStationsDTO("역이름1", "역이름2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선 삭제: 노선 목록에 존재하지 않는 이름이면 예외 발생")
    @Test
    void deleteLineInLine() {
        assertThatThrownBy(() -> LineService.deleteLine(new LineDTO("테스트노선이름")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}