package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(3, Calculator.add("1\n2"));
    }

	@Test
    public void testCommaAndNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testDifferentDelimiterWithCommaAndNewLine(){
        assertEquals(10, Calculator.add("//;\n1;2,3\n4"));
    }

    /*@Test
    public void testNegativeNumberException(){
        assertEquals("Negatives not allowed: -1", Calculator.hasNegative("-1,2"));
    }

    @Test
    public void testNegativeNumberExceptionMoreThanOne(){
        assertEquals("Negatives not allowed: -4,-5", Calculator.hasNegative("2,-4,3,-5"));
    }*/

    @Test
    public void testNumberBiggerThan1000(){
        assertEquals(3, Calculator.add("1,2,1001"));
    }

    @Test
    public void testDelimiterOfAnyLength(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testMultipleDelimiter(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

}