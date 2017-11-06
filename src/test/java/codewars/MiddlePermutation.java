package codewars;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MiddlePermutation {
    @Test
    public void basicTests() {
        assertEquals("bac", MiddlePermutation.findMidPerm("abc"));
        assertEquals("bdca", MiddlePermutation.findMidPerm("abcd"));
        assertEquals("cbxda", MiddlePermutation.findMidPerm("abcdx"));
        assertEquals("cxgdba", MiddlePermutation.findMidPerm("abcdxg"));
        assertEquals("dczxgba", MiddlePermutation.findMidPerm("abcdxgz"));
    }
    
    public static String findMidPerm(String strng) {
    	strng.split("");
        return "";
    }
}