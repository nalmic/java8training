package codewars;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequence {
	   @Test
	    public void exampleTests() {
	        assertEquals("abc", LongestCommonSubsequence.lcs("abcdef", "abc"));
	        assertEquals("ab", LongestCommonSubsequence.lcs("abrdef", "abc"));
	        assertEquals("a", LongestCommonSubsequence.lcs("geaggg", "abc"));
	        assertEquals("a", LongestCommonSubsequence.lcs("a", "abc"));
	        assertEquals("v", LongestCommonSubsequence.lcs("vvdd", "vssa"));
	        assertEquals("", LongestCommonSubsequence.lcs("fff", "abc"));
	        assertEquals("a", LongestCommonSubsequence.lcs("aa", "bad"));
	        assertEquals("a", LongestCommonSubsequence.lcs("aa", "bad"));
	        assertEquals("", LongestCommonSubsequence.lcs("a", "b"));
	        assertEquals("abc", LongestCommonSubsequence.lcs("abcdef", "abc"));
	        assertEquals("acf", LongestCommonSubsequence.lcs("abcdef", "acf"));
	        assertEquals("12356", LongestCommonSubsequence.lcs("132535365", "123456789"));
	    }
	   
	    public static String lcs(String x, String y) {
	    	String max = "";
	    	for (int i = 0; i <= x.length(); i++) {
	    		for (int j = i; j <= x.length(); j++) {
	    			if (max.length() < j - i) {
	    				if (y.contains(x.substring(i, j)))
	    					max = x.substring(i, j);
	    				else 
	    					break;
	    			} 
	    		}
	    	}
	    	return max;
	    }
}
