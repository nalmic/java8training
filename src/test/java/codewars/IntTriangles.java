package codewars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class IntTriangles {
    public static int giveTriang(int per) {
    	int result=0;
    	for (float a=1;a<=per/2; a++) {
    		for (float b=a;b<=per/2; b++) {
    			for (float c=b;c<=per/2; c++) {
    				if (a+b+c>per) break;
    				if (c*c-a*a-b*b == a*b)
    					result++;
    			}	
    		}	
		}
    	return result;
    }	
    
    private static void testing(int i, int results) {
        assertEquals(results, i);
    }
    public static void tests(int[] list1, int[] results) {
        for (int i = 0; i < list1.length; i++)
            testing(IntTriangles.giveTriang(list1[i]), results[i]);
        return;
    }  
    
    @Test
    public void test1() {
        System.out.println("Basic Tests");
        int[] list1 = new int[] {5, 15, 30, 50, 80, 90, 100, 150, 180, 190};
        int[] results = new int[] {0, 1, 3, 5, 11, 13, 14, 25, 32, 35};
        tests(list1, results);
    }
}
