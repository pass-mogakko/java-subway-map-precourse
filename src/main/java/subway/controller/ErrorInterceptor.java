package subway.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;
import subway.view.OutputView;

public class ErrorInterceptor {
    private ErrorInterceptor() {
    }

    public static <T> T repeatUntilGetLegalAnswer(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    public static void repeatUntilNoArgumentException(Controller controller, Consumer<Controller> function) {
        while (true) {
            try {
                function.accept(controller);
                return;
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception.getMessage());
            }
        }
    }
}
