package subway.service;

import java.util.List;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.dto.SectionDto;

public class SectionManageService {

    public void registerSection(String lineName, String stationName, int order) {
        Station station = StationRepository.findStationByName(stationName);
        SectionRepository.registerSection(lineName, station, order);
    }

    public void deleteSection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        section.deleteStationByName(stationName);
    }

    public List<SectionDto> findAllSectionDtos() {
        return SectionRepository.findAllSectionDtos();
    }
}
