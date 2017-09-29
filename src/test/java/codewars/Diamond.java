package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Diamond {
    @Test
    public void testDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), Diamond.print(3));
    }

    @Test
    public void testDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), Diamond.print(5));
    }

    public static String print(int n) {
        if (n % 2 == 0 || n < 0) return null;
        StringBuilder sb = new StringBuilder(printLine(n,0));
        for (int star = n-2, space = 1; star > 0; star-=2, space++){
            sb.insert(0,printLine(star,space));
            sb.append(printLine(star, space));
        }
        return sb.toString();
    }
    private static String printLine(int star, int space){
        StringBuilder line = new StringBuilder();
        for (int pos = 0; pos < star+space; pos++){
            line.append(pos < space ? " " : "*");
        }
        return line.append("\n").toString();
    }
}
