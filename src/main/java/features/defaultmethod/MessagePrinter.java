package features.defaultmethod;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessagePrinter implements Splittable{

    @Override
    public List<String> splitWith(String text, String spliterator) {
        return Stream.of(text.split(spliterator))
                .collect(Collectors.toList());
    }
}
