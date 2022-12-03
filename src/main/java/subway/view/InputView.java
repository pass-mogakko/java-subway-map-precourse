package subway.view;

import java.util.Scanner;

public class InputView {
    static final Scanner scanner = new Scanner(System.in);

    public static String inputFunction(){
        System.out.print(System.lineSeparator());
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.next();
    }

    public static String inputRegisterStation(){
        System.out.print(System.lineSeparator());
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.next();
    }

    public static String inputDeleteStation(){
        System.out.print(System.lineSeparator());
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.next();
    }
}
