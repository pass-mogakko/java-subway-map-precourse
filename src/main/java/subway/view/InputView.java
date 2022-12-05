package subway.view;

import java.util.Scanner;

public class InputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String inputFunction() {
        System.out.print(System.lineSeparator());
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.next();
    }

    // Station
    public static String inputRegisterStation() {
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputDeleteStation() {
        System.out.print(System.lineSeparator());
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.next();
    }

    // Line
    public static String inputRegisterLineName() {
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputDeleteLineName() {
        System.out.print(System.lineSeparator());
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputUpBoundTerminus() {
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputDownBoundTerminus() {
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.next();
    }

    // Section
    public static int inputOrder() {
        System.out.print(System.lineSeparator());
        System.out.println("## 순서를 입력하세요.");
        return scanner.nextInt();
    }

    public static String inputDeleteSectionLineName() {
        System.out.print(System.lineSeparator());
        System.out.println("## 삭제할 구간의 노선 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputRegisterSectionStationName() {
        System.out.print(System.lineSeparator());
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return scanner.next();
    }
}
