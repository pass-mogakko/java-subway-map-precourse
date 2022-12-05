package subway.view.constants.menu;

public enum PathMenu implements Menu {
    PATH_CREATE("구간 등록", SubCommand.CREATE),
    PATH_DELETE("구간 삭제", SubCommand.DELETE),
    BACK("돌아가기", SubCommand.BACK);

    private final String value;
    private final SubCommand command;

    PathMenu(String value, SubCommand command) {
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
