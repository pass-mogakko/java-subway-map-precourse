package subway;

import subway.domain.global.SystemController;

public class Application {

    public static void main(String[] args) {
        SystemController systemController = new SystemController();
        systemController.run();
    }

}
