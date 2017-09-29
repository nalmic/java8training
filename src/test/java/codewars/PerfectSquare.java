package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectSquare {
    @Test
    public void test1() {
        assertEquals(144, findNextSquare(121));
    }

    @Test
    public void test2() {
        assertEquals(676, findNextSquare(625));
    }

    @Test
    public void test3() {
        assertEquals(-1, findNextSquare(114));
    }

    private int findNextSquare(int a){
        double base = Math.sqrt(a);
        return (Math.floor(base) == base) ? (int)Math.pow(++base, 2) : -1;

    }


}
