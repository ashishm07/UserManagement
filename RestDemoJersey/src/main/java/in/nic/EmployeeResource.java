package in.nic;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
		
	EmployeeDao db = new EmployeeDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON )
	public List<Employee> getEmployee() {
		
		System.out.println("Method Working..");
				
		return db.getEmployees() ;
	}
	
	@POST
	@Path("emp")
	public Employee createEmployee(Employee e) {
		System.out.println(e);
		db.create(e);
		
		return e;
	}
}
