package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    static {
        paths.add(new Path("2호선", List.of("교대역", "강남역", "역삼역")));
        paths.add(new Path("3호선", List.of("교대역", "남부터미널역", "역삼역", "매봉역")));
        paths.add(new Path("신분당선", List.of("강남역", "양재역", "양재시민의숲역")));
    }

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        // TODO line, station 검증
        paths.add(path);
    }

    // TODO 특정 노선의 경로 내 특정 역만 등록, 삭제하기
}
