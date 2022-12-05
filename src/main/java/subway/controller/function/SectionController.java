package subway.controller.function;

import subway.constants.menu.Menu;
import subway.controller.ManagementController;
import subway.domain.command.ManageCommand;
import subway.service.SectionService;
import subway.view.input.InputView;
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

    public ManageCommand readCommand(Menu menu) {
        try {
            ManageCommand manageCommand = InputView.readManageMenu(menu);
            return manageCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private void executeByCommand(ManageCommand manageCommand) {
        try {
            insert(manageCommand);
            delete(manageCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.INSERT)) {
            String lineName = sectionInputView.readLineName();
            String stationName = sectionInputView.readStationName();
            int index = sectionInputView.readIndex();
            sectionService.insert(lineName, stationName, index);
        }
    }

    public void delete(ManageCommand manageCommand) {
        if (manageCommand.equals(ManageCommand.DELETE)){
            String lineName = sectionInputView.readDeleteLineName();
            String stationName = sectionInputView.readDeleteStationName();
            sectionService.delete(lineName, stationName);
        }
    }

}
