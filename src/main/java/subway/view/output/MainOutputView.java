package subway.view.output;

import subway.constants.menu.Menu;


public class MainOutputView implements OutputView {

    public static void printMenu(Menu menu) {
        System.out.println(menu.getMenu());
        System.out.println();
    }
    
}