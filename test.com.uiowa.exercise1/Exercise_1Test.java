import static org.junit.Assert.*;

import org.junit.Test;

import com.uiowa.exercise1.Exercise_1;

public class Exercise_1Test {

	@Test
	public void test1() {
		String[] input = new String[] { "A1", "F1", "F12", "F7", "A9", "A3" };
		String[] expected = new String[] { "A1", "A3", "A9", "F1", "F7", "F12" };
		String[] result = new String[6];
		//assertEquals(true, true);
		result = Exercise_1.solution(input);
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test2() {
		String[] input = new String[] { "A1", "F134", "F12", "F7", "A9", "A3" };
		String[] expected = new String[] { "A3", "A1", "A9", "F7", "F12", "F134" };
		String[] result = new String[6];
		result = Exercise_1.solution(input);
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test3() {
		String[] input = new String[] {  };
		String[] expected = new String[] {  };
		String[] result = new String[6];
		//assertEquals(true, true);
		result = Exercise_1.solution(input);
		assertArrayEquals(expected, result);
	}

}
