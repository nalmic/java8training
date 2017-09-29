package algorithms;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chapter1 {

    @Test
    public void ex_1_1_1_a(){
        int valueInt = (0+15) / 2;
        double valueDouble = (0+15) / 2;

        assertEquals(7, valueInt);
        assertEquals(7, valueDouble, 0.01d);         // Assert equals double needs delta
    }

    @Test
    public void ex_1_1_1_b(){
        double value = 2.0e-6 * 100000000.1;
        assertEquals(200.0000002, value, 1e-10);
    }

    @Test
    public void ex_1_1_1_c(){
        boolean value = true && false || true && true;
        assertEquals(true, value);
    }

    @Test
    public void ex_1_1_2_a(){
        assertEquals(1.618, (1 + 2.236) / 2, 1e-5);
        assertEquals(10.0, 1 + 2 + 3 + 4.0, 1e-1);
        assertEquals(true, 4.1 >= 4);
        assertEquals("33", 1 + 2 + "3");             // This is interesting
    }

    @Test
    public void ex_1_1_4(){
        int a = 1, b = 2, c;
        //if (a > b) then c = 0; // no such keyword "then"
        //if a > b {c = 0}; // lack of parenthesis
        if (a>b) c = 0; //ok
        //if (a>b) c = 0 else b = 0; //lack of semicolon
    }

    @Test
    public void ex_1_1_6(){             // interesting! fibonacci in other way
        int f = 0;
        int g = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 15; i++)
        {
            sb.append(f);
            f = f + g;
            g = f - g;
            //System.out.println(String.format("f = %d, g = %d", f, g));
        }
        //f = 0, g = 1
        //f = 1, g = 0
        //f = 1, g = 1
        //f = 2, g = 1
        //f = 3, g = 2
        //f = 5, g = 3
        //f = 8, g = 5
        //f = 13, g = 8
        //f = 21, g = 13
        //f = 34, g = 21
        //f = 55, g = 34
        //f = 89, g = 55
        //f = 144, g = 89
        //f = 233, g = 144
        //f = 377, g = 233
        //f = 610, g = 377
        assertEquals("01123581321345589144233377610", sb.toString());
    }

    @Test
    public void ex_1_1_7_a() {
        double t = 9.0;
        StdOut.printf("%.5f\n", Math.abs(t - 9.0 / t));

        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
        assertEquals(9.0, t, .001);
    }

    @Test
    public void ex_1_1_7_b() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        assertEquals(499500, sum);

    }

    @Test
    public void ex_1_1_7_c() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        assertEquals(1023, sum);

    }

    @Test
    public void ex_1_1_8(){
        System.out.println('b');
        System.out.println('b' + 'c');                  //this is interesting. answer 197
        System.out.println((char) ('a' + 4));
    }


    @Test
    public void ex_1_1_9(){
        int a = 64;
        StringBuilder sb = new StringBuilder();
        do {
            int rest = a % 2;
            a = (a - rest) / 2;
            sb.append(rest);
        } while (a>0);
        assertEquals(Integer.toBinaryString(64), sb.toString());
    }
}