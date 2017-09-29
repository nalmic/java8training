package codewars;

import org.junit.Test;

import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Line {

    @Test
    public void test1() {
        assertEquals("YES", Line.Tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", Line.Tickets(new int []{25, 100}));
    }

    public static String Tickets(int[] peopleInLine)
    {
        int[] bills = {0, 0, 0};
        for (int t : peopleInLine){
            if (t==25) {
                bills[0] = bills[0] + 1;
            }
            else if (t==50) {
                bills[1] = bills[1] + 1;
                bills[0] = bills[0] - 1;
            }
            else if (t==100) {
                bills[2] = bills[2] + 1;
                if (bills[1] > 0) {
                    bills[1] = bills[1] - 1;
                    bills[0] = bills[0] - 1;
                } else {
                    bills[0] = bills[0] - 3;
                }
            }
            if (bills[0] < 0 || bills[1] < 0 || bills[2] < 0) return "NO";
        }
        return "YES";
    }
}
