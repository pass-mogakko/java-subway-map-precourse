package subway.controller;

import subway.domain.line.Line;
import subway.domain.line.LineManage;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LineController {

    public void run() {
        viewLineManages();
        final String manage = readManage();
        if (LineManage.isRegister(manage)) {
            registerLine();
        }
        if (LineManage.isDelete(manage)) {
            deleteLine();
        }
        if (LineManage.isSearchList(manage)) {
            printLineList();
        }
        if (LineManage.isTurnBack(manage)) {
            MainController.viewMain();
        }
    }

    private void viewLineManages() {
        List<String> manages = LineManage.getLineManages();
        OutputView.printLineManageView(manages);
    }

    private String readManage() {
        try {
            String manage = InputView.inputFunction();
            return LineManage.find(manage);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readManage();
        }
    }

    public void registerLine() {
        final Line line = readLineName();
        final Station upBoundTerminus = readUpBoundTerminus();
        final Station downBoundTerminus = readDownBoundTerminus();
        try {
            LineRepository.registerLine(line, upBoundTerminus, downBoundTerminus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        OutputView.printRegisterLineMessage();
        run();
    }

    private void deleteLine() {
        try {
            String name = InputView.inputDeleteLineName();
            LineRepository.deleteLine(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deleteLine();
        }
        OutputView.printDeleteLineMessage();
        run();
    }

    private Line readLineName() {
        try {
            String name = InputView.inputRegisterLineName();
            return LineRepository.validateExistLine(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLineName();
        }
    }

    private Station readUpBoundTerminus() {
        try {
            String name = InputView.inputUpBoundTerminus();
            return StationRepository.validateExistStation(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUpBoundTerminus();
        }
    }

    private Station readDownBoundTerminus() {
        try {
            String name = InputView.inputDownBoundTerminus();
            return StationRepository.validateExistStation(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDownBoundTerminus();
        }
    }

    private void printLineList() {
        final List<Line> lines = LineRepository.lines();
        final List<String> lineList = new ArrayList<>();
        for (Line line : lines) {
            lineList.add(line.getName());
        }
        OutputView.printLineList(lineList);
        MainController.viewMain();
    }
}
