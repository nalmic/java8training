package feauters.defaultmethod;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Endings {
    String SPACE = " ";

    default String showEndTitles(){
        return Stream.of("end of part 1...".split(SPACE))
               .sorted()
               .collect(Collectors.joining(SPACE));
    }
}
