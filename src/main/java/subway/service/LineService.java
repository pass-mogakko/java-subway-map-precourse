package subway.service;

import java.util.List;
import subway.constants.ExceptionMessage;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.dto.RouteMapDTO;

public class LineService {

    public void insert(String lineName, String upStopStationName, String downStopStationName) {
        Station upStopStation = findStationByName(upStopStationName);
        Station downStopStation = findStationByName(downStopStationName);
        Line line = new Line(lineName, upStopStation, downStopStation);
        LineRepository.addLine(line);
    }

    public void delete(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }

    public List<String> read() {
        return LineRepository.readLineNames();
    }

    public List<RouteMapDTO> readRouteMaps() {
        return LineRepository.readRouteMaps();
    }

    private Station findStationByName(String stationName) {
        return StationRepository.findByStationName(stationName)
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_FOUND_STATION));
    }

}
