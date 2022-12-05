package subway.command;

import java.util.Arrays;
import subway.Constants;



public enum MainCommand {
    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    ROUTE("3", "구간 관리"),
    SHOW("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");
    
    private final String command;
    private final String statement;

    MainCommand (final String command, final String statement) {
        this.command = command;
        this.statement = statement;
    }

    public static MainCommand getCommand(String input) {
        return Arrays.stream(MainCommand.values())
                .filter(mainCommand -> input.equals(mainCommand.command))
                .findAny()
                .orElseThrow(()
                        -> new IllegalArgumentException(Constants.ERROR_PREFIX + "선택할 수 없는 기능입니다."));
    }

    @Override
    public String toString() {
        return command + ". " + statement;
    }
}
