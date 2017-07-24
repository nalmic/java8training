package features.defaultmethod;

import java.util.List;

public interface Splittable extends Endings{

    List<String> splitWith(String text, String spliterator);

    default void showLongWords(String text){
        splitWith(text, SPACE).stream()
                .filter(word -> word.length() > 3)
                .forEach(System.out::println);
    }
}
