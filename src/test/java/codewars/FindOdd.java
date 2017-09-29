package codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindOdd {

    @Test
    public void findTest() {
        assertEquals(5, FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, FindOdd.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, FindOdd.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, FindOdd.findIt(new int[]{10}));
        assertEquals(10, FindOdd.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, FindOdd.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }

    public static int findIt(int[] A) {
//        return IntStream.of(A).boxed().collect(Collectors.groupingBy(Integer::intValue))
//                .entrySet().stream().filter(entry -> entry.getValue().size() % 2 == 1)
//                .findFirst().get().getKey().intValue();

        return Arrays.stream(A).reduce(0, (x, y) -> x ^ y);
    }
}
