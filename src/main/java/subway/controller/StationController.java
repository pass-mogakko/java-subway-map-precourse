package subway.controller;

import subway.domain.station.Station;
import subway.domain.station.StationManage;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class StationController {
    StationRepository stationRepository = new StationRepository(new ArrayList<>());

    public void run() {
        view();
        final String manage = readManage();
        if (StationManage.isRegister(manage)) {
            registerStation();
        }
        if(StationManage.isDelete(manage)){
            deleteStation();
        }
        if(StationManage.isSearchList(manage)){
            printStationList();
        }
    }

    private void view() {
        List<String> manages = StationManage.getStationManages();
        OutputView.printStationManageView(manages);
    }

    private void registerStation() {
        try {
            String name = InputView.inputRegisterStation();
            stationRepository.addStation(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        run();
    }

    private void deleteStation(){
        try{
            String name = InputView.inputDeleteStation();
            stationRepository.deleteStation(name);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        run();
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

    private void printStationList() {
        final List<Station> stations = StationRepository.stations();
        final List<String> stationList = new ArrayList<>();
        for(Station station : stations){
            stationList.add(station.getName());
        }
        OutputView.printStationList(stationList);
        MainController.viewMain();
    }
}
