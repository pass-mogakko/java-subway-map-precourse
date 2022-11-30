package subway.domain;


import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @Test
    void 지하철_역_초기_데이터_설정() {
        LineRepository lineRepository = new LineRepository();
        List<String> allLineNameDummy = lineRepository.lines()
                .stream()
                .map(line -> line.getName())
                .collect(Collectors.toList());

        Assertions.assertThat(allLineNameDummy)
                .contains("2호선", "3호선", "신분당선");

    }
}