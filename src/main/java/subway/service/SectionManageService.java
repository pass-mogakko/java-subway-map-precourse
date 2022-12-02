package subway.service;

import subway.constant.ErrorMessage;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;

public class SectionManageService {

    public void validateIsPossibleOrder(String lineName, int order) {
        int sectionSize = SectionRepository.findSectionSizeByLineName(lineName);
        if (isInvalidOrder(sectionSize, order)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_ORDER);
        }
    }

    private boolean isInvalidOrder(int sectionSize, int order) {
        return sectionSize + 1 < order || order < 1;
    }

    public void validateIsAlreadySection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        boolean isContain = section.contains(stationName);
        if (isContain) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_SECTION);
        }
    }

    public void registerSection(String lineName, String stationName, int order) {
        SectionRepository.registerSection(lineName, stationName, order);
    }
}
