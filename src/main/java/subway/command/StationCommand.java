package subway.command;

import java.util.Arrays;
import subway.Constants;



public enum StationCommand {
    ADD("1", "역 등록"),
    REMOVE("2", "역 삭제"),
    SHOW("3", "역 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String statement;

    StationCommand (final String command, final String statement) {
        this.command = command;
        this.statement = statement;
    }

    public static StationCommand getCommand(final String input) {
        return Arrays.stream(StationCommand.values())
                .filter(command -> input.equals(command.name()))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException(Constants.ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }
}
