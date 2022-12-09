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

    static void repeatRun(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            repeatRun(runnable);
        }
    }
}
