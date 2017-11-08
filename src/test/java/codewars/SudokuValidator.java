package codewars;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.stream.IntStream;

import org.junit.Test;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
    	Function<int[], Boolean> f = x ->{
    		return IntStream.of(x).distinct().filter(y->(y>0 && y<10)).count() != 9;
    	};
        for (int i=0; i<9; i++) {
        	if (f.apply(sudoku[i])) return false;
        }
        for (int i=0; i<9; i++) {
        	int line[] = new int[10];
        	for (int j=0; j<9; j++) 
        		line[j] = sudoku[i][j];
        	if (f.apply(line)) return false;
        }
		return true;
    }
    
    @Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertEquals(true, SudokuValidator.check(sudoku));

        sudoku[4][4] = 0;

        assertEquals(false, SudokuValidator.check(sudoku));
    }
}
