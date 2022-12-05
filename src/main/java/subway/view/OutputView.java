package subway.view;

public class OutputView {
    private static final String MAIN_PAGE_INFO = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String STATION_PAGE_INFO = "## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    private static final String LINE_PAGE_INFO = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";

    public static void printMainPage() {
        System.out.println(MAIN_PAGE_INFO);
    }

    public static void print(String message) {
        System.out.println();
        System.out.println(message);
    }

    public static void printStationPage() {
        System.out.println();
        System.out.println(STATION_PAGE_INFO);
    }

    public static void printLinePage() {
        System.out.println();
        System.out.println(LINE_PAGE_INFO);
    }
}
