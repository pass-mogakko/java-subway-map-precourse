package subway.view;

import java.util.List;

public class OutputView {
    private static final String INFO = "[INFO] %s";

    public static void printMainView(List<String> functions) {
        System.out.print(System.lineSeparator());
        System.out.println("## 메인 화면");
        for (String function : functions) {
            System.out.println(function);
        }
    }

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
}
