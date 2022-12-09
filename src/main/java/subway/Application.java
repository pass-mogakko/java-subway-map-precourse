package subway;

import subway.repository.Initializer;
import subway.controller.MainController;

public class Application {
    public static void main(String[] args) {

        Initializer initializer = new Initializer();
        initializer.init();

        MainController controller = new MainController();
        controller.run();

    }
}
