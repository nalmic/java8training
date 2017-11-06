package codewars;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.function.Function;

import org.junit.Test;

public class Conversion {

    public String solution(int n) {
    	int m = Math.abs(n / 1000);    	n %= 1000;
    	int c = Math.abs(n / 100);    	n %= 100;
    	int x = Math.abs(n / 10);
    	int i = n % 10;
    	return part(m, "M", "D", "?")
    			.concat(part(c, "C", "D", "M"))
    			.concat(part(x, "X", "L", "C"))
    			.concat(part(i, "I", "V", "X"));
    }

    private String part(int n, String full, String half, String next) {
    	if (n == 0) return "";
    	else if (n < 3) return String.join("", Collections.nCopies(n, full));
    	else if (n == 4) return "I".concat(half);
    	else if (n < 9) return half.concat(String.join("", Collections.nCopies(n - 5, full)));
    	else return "I".concat(next);
    }
    

    @Test
    public void shouldCovertToRoman() {
        Conversion conversion = new Conversion();
        assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
        assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
        assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
    }
}
