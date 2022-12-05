package subway.controller;

import subway.domain.line.LineRepository;
import subway.domain.section.SectionManage;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.message.ErrorMessage;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SectionController {

    public void run() {
        viewSectionManages();
        final String manage = readManage();
        if (SectionManage.isRegister(manage)) {
            registerSection();
        }
        if (SectionManage.isDelete(manage)) {
            deleteSection();
        }
        if (SectionManage.isTurnBack(manage)) {
            MainController.viewMain();
        }
    }

    private void viewSectionManages() {
        List<String> manages = SectionManage.getSectionManages();
        OutputView.printSectionManageView(manages);
    }

    private String readManage() {
        try {
            String manage = InputView.inputFunction();
            return SectionManage.find(manage);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readManage();
        }
    }

    private void registerSection() {
        try {
            final String lineName = InputView.inputRegisterLineName();
            final Station station = readRegisterStation();
            final int order = readOrder();
            LineRepository.addSection(lineName, station, order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
        OutputView.printRegisterSectionMessage();
        run();
    }

    private void deleteSection() {
        try {
            String lineName = InputView.inputDeleteSectionLineName();
            String stationName = InputView.inputDeleteStation();
            LineRepository.deleteSection(lineName, stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
        OutputView.printDeleteSectionMessage();
        run();
    }

    private Station readRegisterStation() {
        try {
            String StationName = InputView.inputRegisterStation();
            return StationRepository.validateExistStation(StationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRegisterStation();
        }
    }

    public int readOrder() {
        try {
            return InputView.inputOrder();
        } catch (Exception e) {
            System.out.println(ErrorMessage.ORDER_NOT_NUMERIC);
            return readOrder();
        }
    }
}
