package subway.controller;

import subway.command.MainCommand;

import java.util.function.Function;

@FunctionalInterface
public interface Controllable {
    void process();
}
