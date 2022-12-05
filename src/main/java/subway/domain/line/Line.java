package subway.domain.line;

import subway.domain.section.Section;
import subway.domain.station.Station;
import subway.message.ErrorMessage;

import java.util.List;

public class Line {
    private final String name;
    private Section section;

    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MINIMUM_SECTION_ORDER = 1;
    private static final int MINIMUM_SECTION_SIZE = 2;

    public Line(String name) {
        validateNameLength(name);
        this.name = name;
        section = new Section();
    }

    public void addSection(final Station station, final int order) {
        validateSectionOrder(order);
        section.addSection(station, order);
    }

    public void addStations(final List<Station> stations) {
        for (Station station : stations) {
            section.addStation(station);
        }
    }

    public void addTerminus(final Station upBound, final Station downBound) {
        section.addTerminus(upBound, downBound);
    }

    public void deleteSection(String stationName) {
        validateSectionSize();
        section.deleteSection(stationName);
    }

    private void validateSectionSize() {
        if (getSectionSize() <= MINIMUM_SECTION_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_SECTION_SIZE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_LINE_NAME_LENGTH);
        }
    }

    private void validateSectionOrder(final int order) {
        if (order < MINIMUM_SECTION_ORDER) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_LESS_THAN_MINIMUM);
        }
        if (isOverThanSectionSize(order)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_OVER_THAN_SECTION);
        }
    }

    private boolean isOverThanSectionSize(final int order) {
        return order >= getSectionSize();
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return section.getStations();
    }

    public int getSectionSize() {
        return section.getStations().size();
    }
    // 추가 기능 구현
}
