import java.util.List;
import java.util.stream.Stream;

public interface Splittable {
    String SPACE = " ";

    List<String> splitWith(String text, String spliterator);

    default void showLongWords(String text){
        Stream.of(text.split(SPACE))
                .filter(word -> word.length() > 3)
                .forEach(System.out::println);
    }
}
