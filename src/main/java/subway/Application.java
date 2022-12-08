package subway;

import subway.controller.FirstController;

public class Application {
    public static void main(String[] args) {
        FirstController firstController = FirstController.getInstance();
        firstController.execute();
    }
}
