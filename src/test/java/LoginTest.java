
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgate.service.LoginService2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:E:\\Backup\\SearchEmployeeProject\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml"})


public class LoginTest {
	
	@Autowired
	LoginService2 loginservice2;

	@Before
	public static void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		boolean flag= loginservice2.checkLogin("priti.v2technologies@gmail.com", "1234","Employee");

	
	}

}
