package subway.view;

import subway.constant.ErrorMessage;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }
}
