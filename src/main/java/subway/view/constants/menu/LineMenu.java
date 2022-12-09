package subway.view.constants.menu;

public enum LineMenu implements Menu {
    LINE_CREATE("노선 등록", SubCommand.CREATE),
    LINE_DELETE("노선 삭제", SubCommand.DELETE),
    LINE_READ("노선 조회", SubCommand.READ),
    BACK("돌아가기", SubCommand.BACK);

    private final String value;
    private final SubCommand command;

    LineMenu(String value, SubCommand command) {
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
