package codewars;

import org.junit.Test;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;

public class TwoToOne {

    @Test
    public void test() {
        System.out.println("longest Fixed Tests");
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
    }

    public static String longest (String s1, String s2) {
        return IntStream.concat(s1.chars(), s2.chars()).distinct().sorted()
                .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append ).toString();
    }
}
