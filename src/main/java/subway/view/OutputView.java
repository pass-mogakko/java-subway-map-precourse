package subway.view;

import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.RouteCommand;
import subway.command.StationCommand;



public class OutputView {
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
}
