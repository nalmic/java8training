package codewars;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.junit.Test;

public class SumOfDivided {

	@Test
	public void testOne() {
		int[] lst = new int[] {12, 15};
        assertEquals("(2 12)(3 27)(5 15)",
        		SumOfDivided.sumOfDivided(lst));
	}
	
	public static String sumOfDivided(int[] l) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(2, Arrays.stream(l).map(Math::abs).reduce(Math::max).getAsInt()).forEach(
				i -> {
					if (BigInteger.valueOf(i).isProbablePrime(10) && Arrays.stream(l).anyMatch(v->v%i==0)) 
						sb.append(String.format("(%d %d)", i, Arrays.stream(l).filter(v->v%i==0).sum()));
				}
		);
		return sb.toString();
	}
}
