package subway.view.constants;

public enum MainDisplay {

    STATION("역 관리", MainCommand.STATION),
    LINE("노선 관리", MainCommand.LINE),
    PATH("구간 관리", MainCommand.PATH),
    SUBWAY_LINES("지하철 노선도 출력", MainCommand.SUBWAY_LINES),
    QUIT("종료", MainCommand.QUIT);

    private final String menu;
    private final MainCommand command;

    MainDisplay(String menu, MainCommand command) {
        this.menu = menu;
        this.command = command;
    }

    public String getMenu() {
        return menu;
    }

    public String getCommandKey() {
        return command.getKey();
    }
}
