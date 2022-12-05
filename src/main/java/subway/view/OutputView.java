package subway.view;

import java.util.List;

public class OutputView {
    private static final String INFO = "[INFO] %s" + System.lineSeparator();
    public static final String REGISTER_STATION = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION = "지하철 역이 삭제되었습니다.";
    private static final String REGISTER_LINE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_LINE = "지하철 노선이 삭제되었습니다.";
    private static final String REGISTER_SECTION = "구간이 등록되었습니다.";
    private static final String DELETE_SECTION = "구간이 삭제되었습니다.";
    private static final String DOTTED_LINE = "---";

    public static void printMainView(List<String> functions) {
        System.out.print(System.lineSeparator());
        System.out.println("## 메인 화면");
        for (String function : functions) {
            System.out.println(function);
        }
    }

    // Station
    public static void printStationManageView(List<String> manages) {
        System.out.print(System.lineSeparator());
        System.out.println("## 역 관리 화면");
        for (String manage : manages) {
            System.out.println(manage);
        }
    }

    public static void printStationList(List<String> stationList) {
        System.out.print(System.lineSeparator());
        System.out.println("## 역 목록");
        for (String station : stationList) {
            System.out.printf(INFO, station);
        }
    }

    public static void printRegisterStationMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, REGISTER_STATION);
    }

    public static void printDeleteStationMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, DELETE_STATION);
    }

    // Line
    public static void printLineManageView(List<String> manages) {
        System.out.print(System.lineSeparator());
        System.out.println("## 노선 관리 화면");
        for (String manage : manages) {
            System.out.println(manage);
        }
    }

    public static void printRegisterLineMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, REGISTER_LINE);
    }

    public static void printDeleteLineMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, DELETE_LINE);
    }

    public static void printLineList(List<String> lineList) {
        System.out.print(System.lineSeparator());
        System.out.println("## 노선 목록");
        for (String line : lineList) {
            System.out.printf(INFO, line);
        }
    }

    // Section
    public static void printSectionManageView(List<String> manages) {
        System.out.print(System.lineSeparator());
        System.out.println("## 구간 관리 화면");
        for (String manage : manages) {
            System.out.println(manage);
        }
    }

    public static void printRegisterSectionMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, REGISTER_SECTION);
    }

    public static void printDeleteSectionMessage() {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, DELETE_SECTION);
    }

    // LineMap
    public static void printLineMapText() {
        System.out.print(System.lineSeparator());
        System.out.println("## 지하철 노선도");
    }

    public static void printLineName(String lineName) {
        System.out.print(System.lineSeparator());
        System.out.printf(INFO, lineName);
        System.out.printf(INFO, DOTTED_LINE);
    }

    public static void printStations(List<String> stations) {
        for (String stationName : stations) {
            System.out.printf(INFO, stationName);
        }
    }
}
