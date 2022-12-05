package subway.command;

import java.util.Arrays;
import subway.Constants;



public enum LineCommand {
    ADD("1", "노선 등록"),
    REMOVE("2", "노선 삭제"),
    SHOW("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String statement;

    LineCommand (final String command, final String statement) {
        this.command = command;
        this.statement = statement;
    }

    public static LineCommand getCommand(final String input) {
        return Arrays.stream(LineCommand.values())
                .filter(command -> input.equals(command.name()))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException(Constants.ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }

    @Override
    public String toString() {
        return command + ". " + statement;
    }
}
