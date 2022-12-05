package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.util.MessageFactory;

import java.util.LinkedList;
import java.util.List;

import static subway.domain.util.ErrorCode.*;
import static subway.domain.util.SetupConstant.*;

public class LineSectionService {
    private final MessageFactory messageFactory = new MessageFactory();

    public void setUp() {
        LineSection lineSection2 = createLineSection(LINE_2, List.of(STATION_GYODAE, STATION_GANGNAM, STATION_YEOKSAM));
        LineSectionRepository.save(lineSection2);

        LineSection lineSection3 = createLineSection(LINE_3, List.of(STATION_GYODAE, STATION_NAMBU_TERMINAL, STATION_YANGJAE, STATION_MAEBONG));
        LineSectionRepository.save(lineSection3);

        LineSection lineSectionSinbundang = createLineSection(LINE_SINBUNDANG, List.of(STATION_GANGNAM, STATION_YANGJAE, STATION_YANGJAE_CITIZENS_FOREST));
        LineSectionRepository.save(lineSectionSinbundang);
    }

    private LineSection createLineSection(String lineName, List<String> stationNames) {
        Line line = LineRepository.findByName(lineName);

        LinkedList<Station> stations = new LinkedList<>();
        for (String stationName : stationNames) {
            Station station = StationRepository.findByName(stationName);
            stations.add(station);
        }
        return new LineSection(line, stations);
    }

    public void addSection(String lineName, String stationName, int order) {
        Line line = findPresentLine(lineName);
        Station station = findPresentStation(stationName);
        LineSection lineSection = LineSectionRepository.findByLine(line);

        validateNewSection(lineSection, station);
        lineSection.addStation(station, order);
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = findPresentLine(lineName);
        Station station = findPresentStation(stationName);
        LineSection lineSection = LineSectionRepository.findByLine(line);

        validatePresentSection(lineSection, station);
        lineSection.deleteStation(station);
    }

    private Line findPresentLine(String lineName) {
        Line line = LineRepository.findByName(lineName);
        if (line == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(LINE_NOT_FOUND));
        }
        return line;
    }

    private Station findPresentStation(String stationName) {
        Station station = StationRepository.findByName(stationName);
        if (station == null) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(STATION_NOT_FOUND));
        }
        return station;
    }

    private void validateNewSection(LineSection lineSection, Station station) {
        if (lineSection.containsStation(station)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(DUPLICATE_SECTION));
        }
    }

    private void validatePresentSection(LineSection lineSection, Station station) {
        if (!lineSection.containsStation(station)) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(SECTION_NOT_FOUND));
        }
        if (!lineSection.isAffordable()) {
            throw new IllegalArgumentException(messageFactory.makeErrorMessage(TOO_SHORT_SECTION));
        }
    }

}
