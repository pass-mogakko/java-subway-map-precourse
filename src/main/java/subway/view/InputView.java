package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public String requestMainScreenSelection() {
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.MAIN_SCREEN);
        System.out.println();
        Arrays.stream(MainScreenSelection.values())
                .forEach(this::printMainScreenSelectionSentence);
        String selection = scanner.nextLine();
        MainScreenSelection.validate(selection);
        return selection;
    }

    private void printMainScreenSelectionSentence(MainScreenSelection mainScreenSelection) {
        String selection = mainScreenSelection.getSelection();
        String content = mainScreenSelection.getContent();
        String selectionSentence = String.format(Message.SELECTION_MESSAGE_FROM, selection, content);
        System.out.println(selectionSentence);
    }

}
