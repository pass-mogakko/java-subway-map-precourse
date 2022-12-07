package subway.controller;

import subway.command.MainCommand;
import subway.view.InputView;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Repeater {
    static <T> T repeatInput(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return repeatInput(inputReader);
        }
    }

    static <T> T repeatFindByInput(Supplier<T> findReader) {
        try {
            return findReader.get();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return repeatFindByInput(findReader);
        }
    }

    static <T> void repeatConsume(Consumer<T> consumer, T input) {
        try {
            consumer.accept(input);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            repeatConsume(consumer, input);
        }
    }
}
