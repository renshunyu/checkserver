package check.checkserver.base;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringDealTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void strdeal1test() {
		StringDeal sd = new StringDeal();
		assert "dfadd".equals(sd.strdeal("dfadd"));
		//fail("Not yet implemented");
	}
	@Test
	public void strdeal2test() {
		StringDeal sd = new StringDeal();
		assert "dfadd".equals(sd.strdeal2("dfadd"));
		//fail("Not yet implemented");
	}
	@Test
	public void strdeal3test() {
		StringDeal sd = new StringDeal();
		System.out.println(sd.strdeal3("dfadd"));
		assert "<ROOT>dfadd</ROOT>".equals(sd.strdeal3("dfadd"));
		//fail("Not yet implemented");
	}

}
