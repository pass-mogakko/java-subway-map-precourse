package subway.view;

public class OutputView {
    private static final String MAIN_INFO = "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";

    public static void printMain() {
        System.out.println(MAIN_INFO);
    }

    public static void print(String message) {
        System.out.println();
        System.out.println(message);
    }
}
