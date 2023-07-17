package sync;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApplication {
	
	@Test
	public void test1() {
		System.out.println("Running test 1");
	}	
	
	@Test
	public void test2() {
		System.out.println("Running test 2");
		Assert.fail("Failing the test");
	}


}
