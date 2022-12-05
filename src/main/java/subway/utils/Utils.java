package subway.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Utils {

    public static <T> T requestInput(Supplier<T> requestInputFunction, Consumer<String> printErrorFunction) {
        try {
            return requestInputFunction.get();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return requestInput(requestInputFunction, printErrorFunction);
        }
    }

    public static void exceptionHandling(Runnable runnable, Consumer<String> printErrorFunction) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
        }
    }
}
