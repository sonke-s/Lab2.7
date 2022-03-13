import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostfixTest {

	Postfix post = new Postfix();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void evaluateTesta() {
		double output = post.evaluate("123+*");
		assertEquals(5, output);
	}
	
	@Test
	void evaluateTestb() {
		double output = post.evaluate("123*+");
		assertEquals(7, output);
	}

	@Test
	void evaluateTestc() {
		double output = post.evaluate("1234^-+");
		assertEquals(-78, output);
	}

	@Test
	void evaluateTestd() {
		double output = post.evaluate("123*45^6+-+");
		assertEquals(-1023, output);
	}
	
	@Test
	void evaluateTeste() {
		double output = post.evaluate("12+3*456-^+");
		assertEquals(9.25, output);
	}
	
	@Test
	void evaluateTestf() {
		double output = post.evaluate("12+3*456-^+");
		assertEquals(9.25, output);
	}
	
	@Test
	void evaluateTestg() {
		double output = post.evaluate("12+34/+5+678+*+");
		assertEquals(98.75, output);
	}
	
	@Test
	void evaluateTesth() {
		double output = post.evaluate("91-2-32*-1-");
		assertEquals(-1, output);
	}
}
