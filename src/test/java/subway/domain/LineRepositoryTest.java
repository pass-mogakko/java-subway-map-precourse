package subway.domain;


import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @BeforeEach
    void setUp() {
        LineRepository lineRepository = new LineRepository();
    }

    @Test
    void 지하철_역_초기_데이터_설정() {
        List<String> allLineNameDummy = LineRepository.lines()
                .stream()
                .map(line -> line.getName())
                .collect(Collectors.toList());

        Assertions.assertThat(allLineNameDummy)
                .containsExactly("교대역", "강남역", "역삼역", "양재역", "양재시민의숲역", "매봉역");
    }
}