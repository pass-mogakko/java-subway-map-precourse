package subway.command;

import java.util.Arrays;
import subway.Constants;



public enum RouteCommand {
    ADD("1", "구간 등록"),
    REMOVE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final String command;
    private final String statement;

    RouteCommand (final String command, final String statement) {
        this.command = command;
        this.statement = statement;
    }

    public static RouteCommand getCommand(final String input) {
        return Arrays.stream(RouteCommand.values())
                .filter(routeCommand -> input.equals(routeCommand.command))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException(Constants.ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }

    @Override
    public String toString() {
        return command + ". " + statement;
    }
}
