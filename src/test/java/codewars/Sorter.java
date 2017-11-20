package codewars;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
	  public static List<String> sort(List<String> textbooks) {
		  return textbooks.stream().parallel().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
		//return textbooks;
		    //Cramming right before a test can't be that bad?
		  }

	    @Test
	    public void basicTest() {
	        ArrayList<String> sorted = new ArrayList<>();
	        ArrayList<String> strs = new ArrayList<>();
	        for(String s : new String[] {"Algebra", "History", "Geometry", "English"})
	        strs.add(s);
	        for(String s : new String[] {"Algebra", "English", "Geometry", "History"})
	      sorted.add(s);
	        assertEquals(sorted, Sorter.sort(strs));
	    }
	    
	    @Test
	    public void capitalizationTest() {
	        ArrayList<String> sorted = new ArrayList<>();
	        ArrayList<String> strs = new ArrayList<>();
	        for(String s : new String[] {"Algebra", "history", "Geometry", "english"})
	        strs.add(s);
	        for(String s : new String[] {"Algebra", "english", "Geometry", "history"})
	      sorted.add(s);
	        assertEquals(sorted, Sorter.sort(strs));
	    }
	    
	    @Test
	    public void symbolsTest() {
	        ArrayList<String> sorted = new ArrayList<>();
	        ArrayList<String> strs = new ArrayList<>();
	        for(String s : new String[] {"Alg#bra", "$istory", "Geom^try", "**English"})
	        strs.add(s);
	        for(String s : new String[] {"$istory", "**English", "Alg#bra", "Geom^try"})
	      sorted.add(s);
	        assertEquals(sorted, Sorter.sort(strs));
	    }
	    
	    
}
