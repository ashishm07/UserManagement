package in.nic;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
		
	EmployeeDao db = new EmployeeDao();
	
	
	//Retreive all employee details at once
	@GET
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public List<Employee> getEmployee() {
		
		System.out.println("Method Working..");
		return db.getEmployees() ;
	}
	
	
	//Retrieve employee detail for a specific ID
	@GET
	@Path("emp/{id}")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee getOneEmployee(@PathParam("id") int id) {
		return db.getEmployee(id) ;
	}
	
	
	//Add employee(s) using an employee array to the Database.
	@POST
	@Path("emp")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee createEmployee(Employee[] e) {
		System.out.println(e);
		EmployeeDao.create(e);
		return e[e.length - 1 ];
	}
	
	// Testing connection with the database
	@GET
	@Path("connect")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN} )
	public String getConnection() {
		db.connect();
		return "Connected";	
	}
	
	//Post HTTP method to add employees to database
	@POST
	@Path("insert/{name}/{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee insertEmployee( @PathParam("name") String name, @PathParam("id") int id) {
		EmployeeDao.insert(name,id);
		return getOneEmployee(id) ;
		
	}
	
	//Put HTTP method to update employee's ID in database

	@PUT
	@Path("update")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee updateEmployee(Employee[] e) {
		System.out.println(e);
		EmployeeDao.updateId(e);
		return e[e.length - 1 ];
	}
	
	//Put HTTP method to remove employee's record in database.
		
	@DELETE
	@Path("del")
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee deleteEmployee(Employee[] e) {
		System.out.println(e);
		EmployeeDao.remove(e);
		return e[e.length - 1 ];
	}
	
	@POST
	@Path("form")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON , MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON} )
	public Employee insertEmployeeForm( @FormParam("name") String name, @FormParam("id") int id) {
		EmployeeDao.insert(name,id);
		return getOneEmployee(id) ;
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN } )
	public String queryParamInfo( @QueryParam("name") String name, @QueryParam("id") int id  ) {
		return "Sending out details for " + name + " and his id " + id;	
	}
	
}
