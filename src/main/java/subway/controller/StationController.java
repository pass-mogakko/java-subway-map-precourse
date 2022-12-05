package subway.controller;

import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationManage;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StationController {

    public void run() {
        viewStationManages();
        final String manage = readManage();
        if (StationManage.isRegister(manage)) {
            registerStation();
        }
        if (StationManage.isDelete(manage)) {
            deleteStation();
        }
        if (StationManage.isSearchList(manage)) {
            printStationList();
        }
        if (StationManage.isTurnBack(manage)) {
            MainController.viewMain();
        }
    }

    private void viewStationManages() {
        List<String> manages = StationManage.getStationManages();
        OutputView.printStationManageView(manages);
    }

    private String readManage() {
        try {
            String manage = InputView.inputFunction();
            return StationManage.find(manage);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readManage();
        }
    }

    public Station readRegisterStationName() {
        try {
            String StationName = InputView.inputRegisterStation();
            return StationRepository.validateDuplication(StationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readRegisterStationName();
        }
    }

    private void registerStation() {
        Station station = readRegisterStationName();
        StationRepository.addStation(station);
        OutputView.printRegisterStationMessage();
        run();
    }

    private void deleteStation() {
        try {
            String name = InputView.inputDeleteStation();
            LineRepository.validateRegisteredOnLine(name);
            StationRepository.deleteStation(name);
            OutputView.printDeleteStationMessage();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        run();
    }

    private void printStationList() {
        final List<Station> stations = getStations();
        final List<String> stationList = new ArrayList<>();
        for (Station station : stations) {
            stationList.add(station.getName());
        }
        OutputView.printStationList(stationList);
        MainController.viewMain();
    }

    public static List<Station> getStations() {
        return StationRepository.stations();
    }
}
