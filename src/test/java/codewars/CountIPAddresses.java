package codewars;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class CountIPAddresses {

	public static long ipsBetween(String start, String end) {
		List<Integer> s = Stream.of(start.split("\\.")).map(i->Integer.valueOf(i)).collect(Collectors.toList());
		List<Integer> e = Stream.of(end.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
		return (e.get(0)-s.get(0))*256*255*256 +
				(e.get(1)-s.get(1))*256*256 +
				(e.get(2)-s.get(2))*256 +
				(e.get(3)-s.get(3));
	}

	@Test
	public void ipsBetween() throws Exception {
		assertEquals( 1, CountIPAddresses.ipsBetween( "10.0.0.1", "10.0.0.2" ) );
		assertEquals( 50, CountIPAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
		assertEquals( 246, CountIPAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
	}

}
