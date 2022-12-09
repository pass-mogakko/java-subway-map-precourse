package subway.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import subway.view.constants.menu.SubCommand;

public enum ManageControllerHandler {
    CREATE(SubCommand.CREATE, controller -> controller.create()),
    DELETE(SubCommand.DELETE, controller -> controller.delete()),
    READ(SubCommand.READ, controller -> controller.read());

    private static final Map<SubCommand, Consumer<ManageController>> functionByCommand = Arrays.stream(values())
            .collect(Collectors.toMap(value -> value.subCommand, value -> value.function));
    private final SubCommand subCommand;
    private final Consumer<ManageController> function;

    ManageControllerHandler(SubCommand subCommand, Consumer<ManageController> function) {
        this.subCommand = subCommand;
        this.function = function;
    }

    public static void executeFunctionByCommand(ManageController controller, SubCommand command) {
        Consumer<ManageController> selectedFunction = functionByCommand.get(command);
        if (selectedFunction == null) {
            throw new IllegalArgumentException("해당 입력 키워드로 실행할 수 있는 기능이 없습니다.");
        }
        selectedFunction.accept(controller);
    }
}
