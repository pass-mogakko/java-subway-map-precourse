package subway.view;

import java.util.Scanner;
import subway.command.MainCommand;



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

}
