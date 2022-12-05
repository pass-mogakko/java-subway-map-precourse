package subway.domain.line;

import subway.domain.station.Station;
import subway.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    static {
        Line lineTwo = new Line("2호선");
        Line lineThree = new Line("3호선");
        Line lineShinBunDang = new Line("신분당선");
        lines.add(lineTwo);
        lines.add(lineThree);
        lines.add(lineShinBunDang);
        initLineStations(lineTwo, lineThree, lineShinBunDang);
    }

    private static void initLineStations(Line lineTwo, Line lineThree, Line lineShinBunDang) {
        final List<Station> stationsLineTwo
                = List.of(new Station("교대역"), new Station("강남역"), new Station("역삼역"));
        final List<Station> stationsLineThree
                = List.of(new Station("교대역"), new Station("남부터미널역"), new Station("양재역"), new Station("매봉역"));
        final List<Station> stationsLineShinBunDang
                = List.of(new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역"));
        lineTwo.addStations(stationsLineTwo);
        lineThree.addStations(stationsLineThree);
        lineShinBunDang.addStations(stationsLineShinBunDang);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void registerLine(Line line, Station upBoundTerminus, Station downBoundTerminus) {
        lines.add(line);
        line.addTerminus(upBoundTerminus, downBoundTerminus);
    }

    public static void deleteLine(String name) {
        validateDuplication(name);
        deleteLineByName(name);
    }

    private static void deleteLineByName(String name) {
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addSection(String lineName, Station station, int order) {
        lines().stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE))
                .addSection(station, order);
    }

    public static void deleteSection(String lineName, String stationName) {
        lines().stream()
                .filter(line -> Objects.equals(line.getName(), lineName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE))
                .deleteSection(stationName);
    }

    private static boolean hasDuplication(String lineName) {
        return lines()
                .stream()
                .anyMatch(line -> Objects.equals(line.getName(), lineName));
    }

    public static Line validateExistLine(String lineName) {
        if (hasDuplication(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE);
        }
        return new Line(lineName);
    }

    public static void validateDuplication(String lineName) {
        if (!hasDuplication(lineName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_LINE);
        }
    }

    public static void validateRegisteredOnLine(String stationName) {
        if (isRegisteredOnLine(stationName)) {
            throw new IllegalArgumentException(ErrorMessage.REGISTERED_STATION_ON_LINE);
        }
    }

    private static boolean isRegisteredOnLine(String stationName) {
        return lines().stream()
                .anyMatch(line -> line.getStations()
                        .stream()
                        .anyMatch(station -> station.equals(stationName)));
    }
}
