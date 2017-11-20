package codewars;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Test;

public class Calc {
	  public double evaluate(String expr) {
		  try {
			  Stack<Double> stos = new Stack<>();
			  for (String v : expr.split(" ")){
		    	if ("+-/*".contains(v)) {
		    		Double a = stos.pop();
		    		Double b = stos.pop();
		    		switch(v) {
		    			case "+": stos.push(b+a); break;
		    			case "-": stos.push(b-a); break;
		    			case "/": stos.push(b/a); break;
		    			case "*": stos.push(b*a); break;
		    		}
		    	} else {
		    		stos.push(Double.parseDouble(v));
		    	}
			  };
			  return stos.pop();
		  } catch (EmptyStackException e) {
			  return 0;
		  }
	  }
	  

	  @Test
	  public void shouldWorkWithEmptyString() {
	      assertEquals("Should work with empty string", 0, new Calc().evaluate(""), 0);
	  }
	  
	  @Test
	  public void shouldParseNumbers() {
	      assertEquals("Should parse numbers", 3, new Calc().evaluate("1 2 3"), 0);
	  }

	  @Test
	  public void shouldParseFloatNumbers() {
	      assertEquals("Should parse float numbers", 3.5, new Calc().evaluate("1 2 3.5"), 0);
	  }

	  @Test
	  public void shouldSupportAddition() {
	      assertEquals("Should support addition", 4, new Calc().evaluate("1 3 +"), 0);
	  }

	  @Test
	  public void shouldSupportMultiplication() {
	      assertEquals("Should support multiplication", 3, new Calc().evaluate("1 3 *"), 0);
	  }

	  @Test
	  public void shouldSupportSubstraction() {
	      assertEquals("Should support substraction", -2, new Calc().evaluate("1 3 -"), 0);
	  }

	  @Test
	  public void shouldSupportDivision() {
	      assertEquals("Should support division", 2, new Calc().evaluate("4 2 /"), 0);
	  }
}
