package subway;

import subway.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = FrontController.getInstance();
        frontController.execute();
    }
}
