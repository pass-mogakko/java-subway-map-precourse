package subway;

import subway.domain.SystemController;

public class Application {

    public static void main(String[] args) {
        SystemController systemController = new SystemController();
        systemController.run();
    }

}
