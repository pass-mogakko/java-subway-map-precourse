package subway.view.constants.menu;

public enum StationMenu implements Menu {
    STATION_CREATE("역 등록", SubCommand.CREATE),
    STATION_DELETE("역 삭제", SubCommand.DELETE),
    STATION_READ("역 조회", SubCommand.READ),
    BACK("돌아가기", SubCommand.BACK);

    private final String value;
    private final SubCommand command;

    StationMenu(String value, SubCommand command) {
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
