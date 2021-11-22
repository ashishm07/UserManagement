package in.nic;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
		
	EmployeeDao db = new EmployeeDao();
	
	@GET
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public List<Employee> getEmployee() {
		
		System.out.println("Method Working..");
		return db.getEmployees() ;
	}
	
	@GET
	@Path("emp/{id}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee getOneEmployee(@PathParam("id") int id) {
		return db.getEmployee(id) ;
	}
	
	@POST
	@Path("emp")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee createEmployee(Employee[] e) {
		System.out.println(e);
		db.create(e);
		return e[e.length - 1 ];
	}
	
	@GET
	@Path("connect")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public String getConnection() {
		db.connect();
		return "Connected";	
	}
	
	@POST
	@Path("insert/{name}/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee insertEmployee( @PathParam("name") String name, @PathParam("id") int id) {
		EmployeeDao.insert(name,id);
		return getOneEmployee(id) ;
		
	}
	
//	@POST
//	@Path("insertMany/{name}/{id}")
//	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
//	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
//	public Employee insertMultipleEmployee( Employee e) {
//		EmployeeDao.create(e);
//		return getOneEmployee(e) ;
//		
//	}
	
}
