package algorithms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Write a program that takes three integer command-line arguments and prints
//equal if all three are equal, and not equal otherwise
@RunWith(Parameterized.class)
public class ex_1_1_3 {
    @Parameterized.Parameters
    public static  Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0, true},
                {4, 1, 1, false},
                {1, 2, 2, false},
                {1, 2, 4, false},
                {3, 3, 3, true},
                {-0, 0, 1+0-1, true},
                {1, 2, 123422, false},
                {2, 2, 2, true}
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public int a;

    @Parameterized.Parameter(1)
    public int b;

    @Parameterized.Parameter(2)
    public int c;

    @Parameterized.Parameter(3)
    public boolean result;

    @Test()
    public void test(){
        boolean value = a == b && b == c;
        Assert.assertEquals(value, result);
    }
}