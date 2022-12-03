package subway.service;

import static subway.domain.constants.SubwayRule.NAME_MINIMUM_LENGTH;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.StationRepository;
import subway.dto.FinalStationsDTO;
import subway.dto.LineDTO;

// TODO 입력 에러 메시지 상수화 or validate 클래스 분리
public class LineService {

    private LineService() {
    }

    public static List<LineDTO> getAllLines() {
        return LineRepository.lines()
                .stream()
                .map(line -> new LineDTO(line.getName()))
                .collect(Collectors.toList());
    }

    public static void addLine(LineDTO lineDTO, FinalStationsDTO finalStations) {
        String lineName = lineDTO.getName();
        String upFinalStationName = finalStations.getUpFinalStationName();
        String downFinalStationName = finalStations.getDownFinalStationName();
        validateNames(lineName, upFinalStationName, downFinalStationName);

        LineRepository.addLine(new Line(lineDTO.getName()));
        PathRepository.addPath(new Path(lineName, List.of(upFinalStationName, downFinalStationName)));
    }

    private static void validateNames(String lineName, String upFinalStationName, String downFinalStationName) {
        validateLineName(lineName);
        validateNamesToCreate(upFinalStationName, downFinalStationName);
    }

    private static void validateLineName(String name) {
        if (name.length() < NAME_MINIMUM_LENGTH.getValue()) {
            throw new IllegalArgumentException("노선 이름은 최소 2글자 이상이어야 합니다.");
        }
        if (LineRepository.findLineOrNullByName(name) != null) {
            throw new IllegalArgumentException("이미 등록된 노선 이름입니다.");
        }
    }

    private static void validateNamesToCreate(String upFinalStationName, String downFinalStationName) {
        if (StationRepository.findStationOrNullByName(upFinalStationName) == null) {
            throw new IllegalArgumentException("상행 종점역 등록 불가: 존재하지 않는 역 이름입니다.");
        }
        if (StationRepository.findStationOrNullByName(downFinalStationName) == null) {
            throw new IllegalArgumentException("하행 종점역 등록 불가: 존재하지 않는 역 이름입니다.");
        }
    }

    public static void deleteLine(LineDTO lineDTO) {
        String name = lineDTO.getName();
        validateNameToDelete(name);
        LineRepository.deleteLineByName(name);
        PathRepository.deletePath(name);
    }

    private static void validateNameToDelete(String name) {
        if (LineRepository.findLineOrNullByName(name) == null) {
            throw new IllegalArgumentException("삭제할 노선이 노선 목록에 존재하지 않습니다.");
        }
        if (PathRepository.findPathOrNullByLineName(name) == null) {
            throw new IllegalArgumentException("삭제할 노선이 노선 경로 목록에 존재하지 않습니다.");
        }
    }
}
