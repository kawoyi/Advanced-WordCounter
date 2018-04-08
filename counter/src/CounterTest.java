package profile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {
    private static Counter count=new Counter();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFilepath() {
		count.getFilepath();
	}

	@Test
	public void testSetFilepath() {
		count.setFilepath("input.txt");
	}

	@Test
	public void testGetOutputpath() {
		count.getOutputpath();
	}

	@Test
	public void testSetOutputpath() {
		count.getOutputpath();
	}

	@Test
	public void testGetBc() {
		count.getBc();
	}

	@Test
	public void testConcat() {
		count.concat();
	}

	@Test
	public void testIsLetter() {
		count.isLetter();
	}

	@Test
	public void testIsConnector() {
		count.isConnector();
	}

	@Test
	public void testIsCharacter() {
		count.isCharacter('#');
		count.isCharacter('$');
		count.isCharacter('%');
		count.isCharacter('^');
	}

	@Test
	public void testRetract() {
		count.retract();
	}

	@Test
	public void testAnalyse() {
		count.setFilepath("input.txt");
		FileUnit.readFile(count.getFilepath(), count.getBuffer());
	}

}
