package subway.view;

import java.util.List;
import java.util.Map;
import subway.Constants;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.RouteCommand;
import subway.command.StationCommand;



public class OutputView {
    private static final String SUCCESS_ADD_STATION = Constants.INFO_PREFIX + "지하철 역이 등록되었습니다.";
    private static final String SUCCESS_REMOVE_STATION = Constants.INFO_PREFIX + "지하철 역이 삭제되었습니다.";
    private static final String INFORMATION = Constants.INFO_PREFIX + "%s" + System.lineSeparator();
    private static final String SEPARATOR = Constants.INFO_PREFIX + "------";

    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.println(mainCommand);
        }
        System.out.println();
    }

    public static void printStationMenu() {
        System.out.println("## 역 관리 화면");
        for (StationCommand stationCommand : StationCommand.values()) {
            System.out.println(stationCommand);
        }
        System.out.println();
    }

    public static void printLineMenu() {
        System.out.println("## 노선 관리 화면");
        for (LineCommand lineCommand : LineCommand.values()) {
            System.out.println(lineCommand);
        }
        System.out.println();
    }

    public static void printRouteMenu() {
        System.out.println("## 구간 관리 화면");
        for (RouteCommand routeCommand : RouteCommand.values()) {
            System.out.println(routeCommand);
        }
        System.out.println();
    }

    public static void printStationAddSuccess() {
        System.out.println();
        System.out.println(SUCCESS_ADD_STATION);
    }

    public static void printStationRemoveSuccess() {
        System.out.println();
        System.out.println(SUCCESS_REMOVE_STATION);
    }

    public static void printStations(List<String> stationNames) {
        stationNames.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printLines(List<String> lineNames) {
        lineNames.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printRoute(String lineName, List<String> stationNames) {
        System.out.printf(INFORMATION, lineName);
        System.out.println(SEPARATOR);
        for (String stationName : stationNames) {
            System.out.printf(INFORMATION, stationName);
        }
        System.out.println();
    }
}
