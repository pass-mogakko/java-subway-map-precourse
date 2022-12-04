package subway.view.constants.menu;

public enum MainMenu implements Menu {
    STATION("역 관리", MainCommand.STATION),
    LINE("노선 관리", MainCommand.LINE),
    PATH("구간 관리", MainCommand.PATH),
    SUBWAY_LINES("지하철 노선도 출력", MainCommand.SUBWAY_LINES),
    QUIT("종료", MainCommand.QUIT);

    private final String value;
    private final MainCommand command;

    MainMenu(String value, MainCommand command) {
        this.value = value;
        this.command = command;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getCommandKey() {
        return command.getKey();
    }
}
