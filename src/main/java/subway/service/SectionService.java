package subway.service;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {

    public void insert(String lineName, String stationName, int index) {
        Station station = StationRepository.findByStationName(stationName);
        Line line = LineRepository.findByName(lineName);
        line.addStation(index, station);
    }

    public void delete(String lineName, String stationName) {
        Station station = StationRepository.findByStationName(stationName);
        Line line = LineRepository.findByName(lineName);
        line.deleteStation(station);
    }

    public void insertSections(String lineName, int startIndex, String...stationNames) {
        IntStream.rangeClosed(startIndex, (stationNames.length - 2))
                .forEach(index -> insertSection(lineName,index,stationNames[index]));
    }

}
