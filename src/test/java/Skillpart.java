import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgate.model.Employee;
import com.kgate.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
public class Skillpart {

	
	@Autowired
    EmployeeService employeeservice;
	
	@Test
	public void test() {
		
		
		List<Employee> e=employeeservice.searchEmployeesBySkill("");
		System.out.println(e);
		
		/*fail("Not yet implemented");*/
	}

}
