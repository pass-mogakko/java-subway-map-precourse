package subway.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class SectionsTest {

    @Test
    void 지하철_구간_2호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section twoLineSection = sectionRepository.findSectionByLineName("2호선");
        Stations twoStations = twoLineSection.getStations();

        assertThatCode(() -> twoStations.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> twoStations.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> twoStations.findStationByName("역삼역")).doesNotThrowAnyException();
    }

    @Test
    void 지하철_구간_3호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section threeLineSection = sectionRepository.findSectionByLineName("3호선");
        Stations threeStations = threeLineSection.getStations();

        assertThatCode(() -> threeStations.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> threeStations.findStationByName("남부터미널역")).doesNotThrowAnyException();
        assertThatCode(() -> threeStations.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> threeStations.findStationByName("매봉역")).doesNotThrowAnyException();

    }

    @Test
    void 지하철_구간_신분당선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section sinBunDangLineSection = sectionRepository.findSectionByLineName("신분당선");
        Stations sinBunDangStations = sinBunDangLineSection.getStations();

        assertThatCode(() -> sinBunDangStations.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> sinBunDangStations.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> sinBunDangStations.findStationByName("양재시민의숲역")).doesNotThrowAnyException();


    }
}