package subway.domain.section;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import subway.domain.station.StationGroup;

class SectionRepositoryTest {

    @Test
    void 지하철_구간_2호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section twoLineSection = sectionRepository.findSectionByLineName("2호선");
        StationGroup twoLine = twoLineSection.getStations();

        assertThatCode(() -> twoLine.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> twoLine.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> twoLine.findStationByName("역삼역")).doesNotThrowAnyException();
    }

    @Test
    void 지하철_구간_3호선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section threeLineSection = sectionRepository.findSectionByLineName("3호선");
        StationGroup threeLine = threeLineSection.getStations();

        assertThatCode(() -> threeLine.findStationByName("교대역")).doesNotThrowAnyException();
        assertThatCode(() -> threeLine.findStationByName("남부터미널역")).doesNotThrowAnyException();
        assertThatCode(() -> threeLine.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> threeLine.findStationByName("매봉역")).doesNotThrowAnyException();

    }

    @Test
    void 지하철_구간_신분당선_초기_데이터_설정() {
        SectionRepository sectionRepository = new SectionRepository();
        Section sinBunDangLineSection = sectionRepository.findSectionByLineName("신분당선");
        StationGroup sinBunDangStationGroup = sinBunDangLineSection.getStations();

        assertThatCode(() -> sinBunDangStationGroup.findStationByName("강남역")).doesNotThrowAnyException();
        assertThatCode(() -> sinBunDangStationGroup.findStationByName("양재역")).doesNotThrowAnyException();
        assertThatCode(() -> sinBunDangStationGroup.findStationByName("양재시민의숲역")).doesNotThrowAnyException();
    }

}