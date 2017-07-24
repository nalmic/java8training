package features.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SorterTest {

    @Test
    public void sortCharacters(){
        List<Character> input = "This is a sample text input which will be sorted"
                .chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .map(c -> new Character(c))
                .collect(Collectors.toList());
        input.stream().forEach(System.out::print);
    }

    @Test
    public void sortInts(){
        List<Integer> input = Arrays.asList(1, 4, 8, 3, 6 , 9, 2);
        input.sort(Sorter::compare);
        input.stream().forEach(System.out::println);
    }

    @Test
    public void sortDoubles(){
        List<Double> input = Arrays.asList(1.2, 4.1, 8.4, 3.3, 6.7 , 9.9, 2.5);
        input.sort((t0, t1) -> (int)((t0.doubleValue() - t1.doubleValue()) * 10));
        input.stream().forEach(System.out::println);
    }

    @Test
    public void sortStringLengthsWithFilter(){
        String input = "You shall find of the king a husband, madam; you,\n" +
                "sir, a father: he that so generally is at all times\n" +
                "good must of necessity hold his virtue to you; whose\n" +
                "worthiness would stir it up where it wanted rather\n" +
                "than lack it where there is such abundance.";
        Stream.of(input.split(" "))
                .distinct()
                .filter(t0 -> t0.length() > 3)
                .sorted((t0, t1) -> t0.length() - t1.length())
                .map(t0 -> t0.toUpperCase())
                .forEach(t0 -> System.out.println("[" + t0.length() + "] " + t0));
    }
}
