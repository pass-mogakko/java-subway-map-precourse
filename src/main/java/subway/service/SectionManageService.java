package subway.service;

import java.util.List;
import subway.constant.Constant;
import subway.constant.ErrorMessage;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.dto.SectionDto;

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

    public void validateIsRegisterSection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        boolean isContain = section.contains(stationName);
        if (isContain) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_SECTION);
        }
    }

    public void registerSection(String lineName, String stationName, int order) {
        SectionRepository.registerSection(lineName, stationName, order);
    }

    public void validateIsUnregisterSection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        boolean isContain = section.contains(stationName);
        if (!isContain) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION);
        }
    }

    public void deleteSection(String lineName, String stationName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        section.deleteStationByName(stationName);
    }

    public void validateIsPossibleDelete(String lineName) {
        Section section = SectionRepository.findSectionByLineName(lineName);
        if (section.size() <= Constant.SECTION_SIZE_MIN) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_SECTION_SIZE);
        }
    }

    public List<SectionDto> findAllSectionDtos() {
        return SectionRepository.findAllSectionDtos();
    }
}
