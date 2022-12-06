package subway.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class RouteRepositoryTest {
    @Test
    void 예외_존재하지_않는_노선_삭제() {
        assertThatThrownBy(() -> RouteRepository.removeRouteByLineName("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 존재하는_노선_삭제() {
        List<Route> routes = new ArrayList<>();

        routes.add(new Route("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역")));
        routes.add(new Route("신분당선", List.of("강남역", "양재역", "양재시민의숲역")));

        RouteRepository.removeRouteByLineName("2호선");

        System.out.println(RouteRepository.routes());
    }

    @Test
    void 예외_존재하는_역_추가() {
        assertThatThrownBy(() -> RouteRepository.addStation("3호선", "교대역", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_존재하지_않는_노선에_역_추가() {
        assertThatThrownBy(() -> RouteRepository.addStation("경춘선", "교대역", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1000})
    void 예외_범위_외에_역_추가(int location) {
        assertThatThrownBy(() -> RouteRepository.addStation("2호선", "양재역", location))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 역_추가() {
        RouteRepository.addStation("2호선", "양재역", 1);

        System.out.println(RouteRepository.getRouteByLineName("2호선"));
    }

    @Test
    void 예외_존재하지_않는_역_삭제() {
        assertThatThrownBy(() -> RouteRepository.removeStation("2호선", "삼척역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_존재하지_않는_노선_선택_및_역_삭제() {
        assertThatThrownBy(() -> RouteRepository.removeStation("경춘선", "양재역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_종점만_있는_구간() {
        StationRepository.addStation("춘천역");
        StationRepository.addStation("김유정역");
        LineRepository.addLine("경춘선", "춘천역", "김유정역");

        System.out.println(RouteRepository.routes());

        assertThatThrownBy(() -> RouteRepository.removeStation("경춘선", "춘천역"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}