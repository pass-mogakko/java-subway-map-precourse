package subway.controller.function;

import subway.constants.ExceptionMessage;
import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.service.SectionService;
import subway.view.input.MainInputView;
import subway.view.input.SectionInputView;

public class SectionController implements ManagementController {

    private final SectionService sectionService = new SectionService();
    private final SectionInputView sectionInputView = new SectionInputView();

    @Override
    public void execute() {
        while (true) {
            ManageCommand manageCommand = readCommand(Menu.SECTION);
            if (manageCommand == null) {
                continue;
            }
            if (manageCommand.equals(ManageCommand.BACK)) {
                break;
            }
            executeByCommand(manageCommand);
        }
    }

    @Override
    public void insert() {
        String lineName = sectionInputView.readLineName();
        String stationName = sectionInputView.readStationName();
        int index = sectionInputView.readIndex();
        sectionService.insertSection(lineName, index, stationName);
    }

    @Override
    public void delete() {
        String lineName = sectionInputView.readDeleteLineName();
        String stationName = sectionInputView.readDeleteStationName();
        sectionService.delete(lineName, stationName);
    }

    @Override
    public void read() {
        throw new IllegalArgumentException(ExceptionMessage.CANT_CHOOSE);
    }

    public ManageCommand readCommand(Menu menu) {
        try {
            ManageCommand manageCommand = MainInputView.readManageMenu(menu);
            return manageCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void executeByCommand(ManageCommand manageCommand) {
        try {
            manageCommand.executeByCommand(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
