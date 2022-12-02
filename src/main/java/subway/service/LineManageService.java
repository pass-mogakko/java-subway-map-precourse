package subway.service;

import subway.domain.line.LineRepository;

public class LineManageService {

    public static void validateIsExistLine(String lineName) {
        LineRepository.validateIsExistLine(lineName);
    }
}
