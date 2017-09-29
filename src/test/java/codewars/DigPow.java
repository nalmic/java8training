package codewars;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DigPow {
    @Test
    public void Test1() {
        assertEquals(1, DigPow.digPow(89, 1));
    }
    @Test
    public void Test2() {
        assertEquals(-1, DigPow.digPow(92, 1));
    }
    @Test
    public void Test3() {
        assertEquals(51, DigPow.digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        double result = 0;
        List<Integer> list = new Integer(n).toString().chars().map(d -> d - '0').boxed().collect(Collectors.toList());
        for (int d : list){
            result += Math.pow(d, p++);
        }
        return (((int)result)%n == 0) ? (int)result/n : -1;
    }
}
