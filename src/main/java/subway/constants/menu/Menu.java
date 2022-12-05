package subway.constants.menu;

public enum Menu {

    MAIN(new MainView(), new String[]{"1", "2", "3", "4", "Q"}),
    STATION(new StationView(), new String[]{"1", "2", "3", "B"}),
    LINE(new LineView(), new String[]{"1", "2", "3", "B"}),
    SECTION(new SectionView(), new String[]{"1", "2", "B"});

    private final View view;
    private final String[] acceptCommand;

    Menu(View view, String[] acceptCommand) {
        this.view = view;
        this.acceptCommand = acceptCommand;
    }

    public String getMenu() {
        return view.getMenu();
    }

    public String[] getAcceptCommand() {
        return this.acceptCommand;
    }

}

