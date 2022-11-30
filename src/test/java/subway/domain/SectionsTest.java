package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SectionsTest {

    @Test
    void 지하철_구간_2호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section twoLineSection = sectionRepository.findSectionByLineName("2호선");
        Stations twoStations = twoLineSection.getStations();

        Assertions.assertThatCode(() -> twoStations.findStationByStationName("교대역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> twoStations.findStationByStationName("강남역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> twoStations.findStationByStationName("역삼역"))
                .doesNotThrowAnyException();
    }

    @Test
    void 지하철_구간_3호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section threeLineSection = sectionRepository.findSectionByLineName("3호선");
        Stations threeStations = threeLineSection.getStations();

        Assertions.assertThatCode(() -> threeStations.findStationByStationName("교대역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> threeStations.findStationByStationName("남부터미널역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> threeStations.findStationByStationName("양재역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> threeStations.findStationByStationName("매봉역"))
                .doesNotThrowAnyException();

    }

    @Test
    void 지하철_구간_신분당선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section sinBunDangLineSection = sectionRepository.findSectionByLineName("신분당선");
        Stations sinBunDangStations = sinBunDangLineSection.getStations();

        Assertions.assertThatCode(() -> sinBunDangStations.findStationByStationName("강남역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> sinBunDangStations.findStationByStationName("양재역"))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> sinBunDangStations.findStationByStationName("양재시민의숲역"))
                .doesNotThrowAnyException();


    }
}