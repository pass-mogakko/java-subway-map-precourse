package subway.service;

import java.util.List;
import subway.constant.ErrorMessage;
import subway.domain.station.StationRepository;

public class StationManageService {

    public void registerStation(String registerStation) {
        StationRepository.addStation(registerStation);
    }

    public void deleteStation(String deleteStation) {
        StationRepository.deleteStation(deleteStation);
    }

    public List<String> lookupStation() {
        return StationRepository.findAllStationNames();
    }

    public void validateIsRegisterStation(String station) {
        boolean isRegisterStation = StationRepository.isRegisterStation(station);
        if (!isRegisterStation) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_STATION);
        }
    }

    public void validateIsUnregisterStation(String station) {
        boolean isRegisterStation = StationRepository.isRegisterStation(station);
        if (isRegisterStation) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION);
        }
    }

}
