package check.checkserver.base;



import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import check.checkserver.ecp.MyException;

public class FileToStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws MyException {
		FileToString fts = new FileToString();
		fts.readFromFile(new File("pom.xml"));
		//fail("");
	}
	
	@Test(expected = MyException.class)
	public void etest() throws MyException {
		FileToString fts = new FileToString();
		//File f = new File("fssf");
		//System.out.println(f.getAbsolutePath());
		
		fts.readFromFile(new File("fssf"));
		

	}

}
