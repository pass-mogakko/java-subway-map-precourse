package subway.domain.line;

import subway.domain.section.LineSection;
import subway.domain.section.LineSectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.util.MessageFactory;

import java.util.LinkedList;
import java.util.List;

import static subway.domain.util.ErrorCode.DUPLICATE_LINE_NAME;
import static subway.domain.util.ErrorCode.STATION_NOT_FOUND;

public class LineService {
    private static final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        LineRepository.setUp();
    }

    public void addLine(String lineName, String upFinalStationName, String downFinalStationName) {
        validateNewName(lineName);
        Line line = new Line(lineName);
        LineRepository.save(line);

        Station firstStation = findPresentStation(upFinalStationName);
        Station lastStation = findPresentStation(downFinalStationName);
        LineSection lineSection = new LineSection(line, new LinkedList<>(List.of(firstStation, lastStation)));
        LineSectionRepository.save(lineSection);
    }

    private void validateNewName(String name) {
        Line line = LineRepository.findByName(name);
        if (line != null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_LINE_NAME));
        }
    }

    private Station findPresentStation(String name) {
        Station station = StationRepository.findByName(name);
        if (station == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_FOUND));
        }
        return station;
    }
}
