package subway.view.input;

import java.util.Scanner;

public interface InputView {
    static final Scanner scanner = new Scanner(System.in);

    final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
}
