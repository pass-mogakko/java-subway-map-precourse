package subway.service;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class LineManageService {

    public static void registerLine(String registerLine, String firstStationName, String lastStationName) {
        Station firstStation = StationRepository.findStationByName(firstStationName);
        Station lastStation = StationRepository.findStationByName(lastStationName);
        LineRepository.addLine(registerLine);
        Line line = LineRepository.findLineByName(registerLine);
        SectionRepository.registerSection(line, firstStation, lastStation);
    }

    public void deleteLine(String lineName) {
        LineRepository.deleteLineByName(lineName);
    }

    public List<String> lookupLine() {
        return LineRepository.findAllLineNames();
    }
}
