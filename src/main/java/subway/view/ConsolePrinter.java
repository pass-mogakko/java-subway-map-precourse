package subway.view;

import subway.view.constants.Format;

public class ConsolePrinter {

    static void printBlankLine() {
        System.out.println();
    }

    static void printLine(Object content) {
        // TODO 출력값 검증
        System.out.println(content);
    }

    static void printFormattedLine(Format format, Object... content) {
        // TODO 출력값 검증
        System.out.printf(format.getValue() + System.lineSeparator(), content);
    }
}
