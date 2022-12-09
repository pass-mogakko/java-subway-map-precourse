package subway.view;

import java.util.Scanner;
import subway.validator.InputValidator;



public class InputView {
    private static final String INPUT_REQUEST = "## 원하는 기능을 선택하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String readMainMenu() {
        OutputView.printMainMenu();

        System.out.println(INPUT_REQUEST);

        return scanner.nextLine();
    }

    public static String readStationMenu() {
        OutputView.printStationMenu();

        System.out.println(INPUT_REQUEST);

        return scanner.nextLine();
    }

    public static String readLineMenu() {
        OutputView.printLineMenu();

        System.out.println(INPUT_REQUEST);

        return scanner.nextLine();
    }

    public static String readRouteMenu() {
        OutputView.printRouteMenu();

        System.out.println(INPUT_REQUEST);

        return scanner.nextLine();
    }

    public static String readAddStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");

        String input = scanner.nextLine();
        InputValidator.validateAddInput(input);

        return input;
    }

    public static String readRemoveStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readAddLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");

        String input = scanner.nextLine();
        InputValidator.validateAddInput(input);

        return input;
    }

    public static String readRemoveLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readUpTerminus() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readDownTerminus() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readAddRouteLine() {
        System.out.println("## 추가할 구간의 노선을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readAddRouteStation() {
        System.out.println("## 추가할 구간의 노선을 입력하세요.");

        String input = scanner.nextLine();
        InputValidator.validateAddInput(input);

        return input;
    }

    public static int readAddRouteLocation() {
        return scanner.nextInt();
    }

    public static String readRemoveRouteLine() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");

        return scanner.nextLine();
    }

    public static String readRemoveRouteStation() {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");

        return scanner.nextLine();
    }
}
