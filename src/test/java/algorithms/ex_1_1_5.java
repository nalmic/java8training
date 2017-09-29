package algorithms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//Write a code fragment that prints true if the double variables x and y are both
//strictly between 0 and 1 and false otherwise.
@RunWith(Parameterized.class)
public class ex_1_1_5 {
    @Parameterized.Parameters
    public static  Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.1, 0.3, true},
                {4.1, 1.3, false},
                {1.1, 0.3, false},
                {1.1, 4.3, false},
                {0.001, 0.43, true},
                {1.1, 123422.3, false},
                {2.1, 2.3, false}
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public double a;

    @Parameterized.Parameter(1)
    public double b;

    @Parameterized.Parameter(2)
    public boolean result;

    @Test()
    public void test(){
        boolean value = a > 0 && a < 1 && b > 0 && b < 1;
        Assert.assertEquals(value, result);
    }
}