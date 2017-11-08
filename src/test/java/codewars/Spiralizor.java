package codewars;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static java.util.Arrays.deepEquals;

public class Spiralizor {

	public static void main(String...strings) {
		 Spiralizor.spiralize(10);		
	}
	
    public static int[][] spiralize(int size) {
    	int[][] result = new int[size][size];
    	int x = 0;
    	int y = 0;
    	int next[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    	int nextCurrent = 0;
    	int blocked = 0;
    	
    	result[0][0] = 1;
    	
    	do {
    		if (x+next[nextCurrent][0] >= 0 && x+next[nextCurrent][0] < size &&
    				y+next[nextCurrent][1] >= 0 && y+next[nextCurrent][1] < size &&
    					result[x+next[nextCurrent][0]][y+next[nextCurrent][1]] == 0 &&
    						check(result, size, x+next[nextCurrent][0], y+next[nextCurrent][1])) {
    			x += next[nextCurrent][0];
    			y += next[nextCurrent][1];
    			result[x][y] = 1;
    			blocked = 0;
    		} else {
    			nextCurrent = (nextCurrent + 1) % 4;
    			blocked++;
    		}
    	} while (blocked < 2);
    	
    	print(result, size);

		return result;
	}
    
    private static void print(int result[][], int size) {
    	for (int i=0; i<size; i++) {
    		for (int j=0; j<size; j++) {
    			System.out.print(String.valueOf(result[i][j]));
			}
    		System.out.println("");
		}    	
    }
    
    private static boolean check(int[][] result, int size, int x, int y) {
    	int count = 0;
    	if (x-1 >= 0 && result[x-1][y] == 1) count++;
    	if (x+1 < size && result[x+1][y] == 1) count++;
    	if (y-1 >= 0 && result[x][y-1] == 1) count++;
    	if (y+1 <size && result[x][y+1] == 1) count++;
    	if (count > 1) return false;
    	else return true;
    }
    

    @Test
    public void test1() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(1),
                new int[][] { { 1 } }));
    }

    @Test
    public void test2() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(2),
                new int[][] {
                        { 1, 1 },
                        { 0, 1 }
                }));
    }

    @Test
    public void test3() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(3),
                new int[][] {
                        { 1, 1, 1 },
                        { 0, 0, 1 },
                        { 1, 1, 1 }
                }));
    }

    @Test
    public void test5() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(5),
                new int[][] {
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1 }
                }));
    }

    @Test
    public void test8() {
        assertTrue(deepEquals(
                Spiralizor.spiralize(8),
                new int[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                }));
    }
}