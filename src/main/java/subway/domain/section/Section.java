package subway.domain.section;

import java.util.List;
import subway.constant.Constant;
import subway.constant.ErrorMessage;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationGroup;
import subway.dto.SectionDto;

public class Section {

    private final Line line;
    private final StationGroup stationGroup;

    public Section(Line line, StationGroup stationGroup) {
        this.line = line;
        this.stationGroup = stationGroup;
    }

    public boolean isSameLineName(String lineName) {
        return line.isSameName(lineName);
    }

    public StationGroup getStations() {
        return stationGroup;
    }

    public int size() {
        return stationGroup.size();
    }

    public void addStation(Station station, int order) {
        if (isInvalidOrder(stationGroup.size(), order)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_ORDER);
        }
        stationGroup.addStation(station, order);
    }

    private boolean isInvalidOrder(int sectionSize, int order) {
        return sectionSize + 1 < order || order < 1;
    }

    public void deleteStationByName(String stationName) {
        if (stationGroup.size() <= Constant.SECTION_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_SIZE);
        }
        stationGroup.deleteStationByName(stationName);
    }

    public SectionDto toDto() {
        String lineName = line.getName();
        List<String> allStationNames = stationGroup.findAllStationNames();
        return new SectionDto(lineName, allStationNames);
    }
}
