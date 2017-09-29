package python;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PythonTraining {

    @Test
    public void cw2() throws IOException {
        List<String> words = new ArrayList<>();

        Files.lines(Paths.get("C:\\Users\\michalna\\tmp\\python\\lorem_ipsum_1k.txt"))
                .map(line -> line.replace(".", ""))
                .map(line -> line.replace(",", ""))
                .map(line -> line.replace("\n", " "))
                .forEach(line -> Arrays.asList(line.split(" "))
                            .stream()
                            .filter(word -> !word.isEmpty())
                            .forEach(word -> words.add(word)));
        System.out.println(words.stream()
                .map(word -> word.toLowerCase())
                .filter(word -> "lorem".equals(word))
                .count());
        System.out.println(words.stream()
                .map(word -> word.toLowerCase())
                .distinct()
                .peek(System.out::println)
                .count());
    }

    @Test
    public void cw3() throws IOException {
        List<String> words = new ArrayList<>();

        Files.lines(Paths.get("C:\\Users\\michalna\\tmp\\python\\lorem_ipsum_1k.txt"))
                .map(line -> line.toLowerCase())
                .map(line -> line.toCharArray())
                .collect(Collectors.toList());
    }
}
