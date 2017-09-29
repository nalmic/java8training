package codewars;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Kata {

    @Test
    public void smallest(){
        int[] array = new int[]{78,56,232,12,11,43};
        assertEquals(11, Arrays.stream(array).min().getAsInt());
    }

    @Test
    public void joinWords() {
        String[] words = new String[]{"Bilal", "Djaghout"};
        String sentence = Arrays.stream(words).collect(Collectors.joining(" ")).toString();
        assertEquals("Bilal Djaghout", sentence);

        String sentence2 = String.join(" ", words);
        assertEquals("Bilal Djaghout", sentence2);
    }

    @Test
    public void test() {
        System.out.println("printerError Fixed Tests");
        String s="aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        assertEquals("3/56", printerError(s));
    }

    private String printerError(String s){
        long negative = s.chars().filter(c -> c > 'm').count();
        long total = s.length();

        return String.format("%d/%d", negative, total);
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    private String createPhoneNumber(int[] nums){
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", Arrays.stream(nums).boxed().toArray());
    }

    @Test
    public void testCalculateYears() {
        System.out.println("Fixed Tests calculateYears");
        assertEquals(3, calculateYears(1000, 0.05, 0.18, 1100));
        assertEquals(14, calculateYears(1000, 0.01625, 0.18, 1200));
        assertEquals(0, calculateYears(1000, 0.05, 0.18, 1000));
    }

    private int calculateYears(double principal, double interest,  double tax, double desired) {
        int years = 0;
        while (principal < desired){
            years++;
            principal += principal * interest * (1 - tax);
        }
        return years;
    }


}
