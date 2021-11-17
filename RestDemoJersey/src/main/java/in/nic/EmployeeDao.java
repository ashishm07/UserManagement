package in.nic;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

//import com.mongodb.BasicDBObject;
//import com.mongodb.Cursor;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.MongoClient;
//import com.mongodb.DBObject;
//

public class EmployeeDao{
	
	List<Employee> empList = new ArrayList() ;
	
	public EmployeeDao() {
		
		Employee emp1 = new Employee();
		emp1.setName("Ashish");
		emp1.setEmpNo(1);
		
		Employee emp2 = new Employee();
		emp2.setName("Sherlock");
		emp2.setEmpNo(2);
		
		System.out.println("Emp1 : " + emp1.getEmpNo());
		
		empList.add(emp1);
		empList.add(emp2);
		
	}
	public List<Employee> getEmployees(){
			return empList; 
	}
		
	public Employee getEmployee(int eNumber) {
			
			for (Employee e1 : empList) {
				if (e1.getEmpNo()==eNumber) {
					return e1;
				} 	
		}
			return null;
	}
	public void create(Employee e) {
		// TODO Auto-generated method stub
		empList.add(e);
	}
}
//
//@SuppressWarnings( "deprecation" )
//public class EmployeeDao {
//
//	public void connect() {
//		// Establishing connection with server
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		System.out.println("Server Connection successfully established");
//
//		// Connecting with database. Creates the database if it doesn't exist.
//		DB dbs = mongoClient.getDB("mydb");
//		System.out.println("Connection to DB successful");
//		System.out.println("Database Name: " + dbs.getName()); // Get DB Name
//
//		//Creates a collection with given name if the collection does not already exist.
//		dbs.getCollection("Employee");
//		mongoClient.close();
//
//	}
//
//	// To check if Employee already exists
//	public static boolean EmployeeDoesExist(String name, String password) {
//
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		DB dbs = mongoClient.getDB("mydb");
//
//		System.out.println("Connection to DB successful");
//		
//		DBCollection col = dbs.getCollection("Employee");
//
//		Employee newEmployee = new Employee(name, password);
//
//		Cursor cursor = col.find();
//
//		boolean EmployeeExists = false;
//
//		while (cursor.hasNext()) {
//
//			DBObject obj = cursor.next();
//			Employee u1 = new Employee(obj.get("name").toString(), obj.get("password").toString());
//			if ((newEmployee.getName().equals(u1.getName())) && (newEmployee.getPassword().equals(u1.getPassword()))) {
//				System.out.println("Employee exists");
//				EmployeeExists = true;
//				break;
//			}
//		}
//		mongoClient.close();
//
//		return EmployeeExists;
//	}
//
//	// Inserting a document in a collection
//	public static void insert(String name, String password) {
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		DB dbs = mongoClient.getDB("mydb");
//
//		DBCollection col = dbs.getCollection("Employee");
//
//		if (EmployeeDoesExist(name, password)) {
//			System.out.println("Employee \"" + name + "\" already exists.");
//		} else {
//			BasicDBObject doc = new BasicDBObject();
//
//			doc.put("name", name);
//			doc.put("password", password);
//
//			col.insert(doc);
//			System.out.println("Document Inserted");
//		}
//		
//		mongoClient.close();
//
//	}
//
//	// Read Operation. Create a cursor object to pass through each document
//	public static List<Employee> retrieveAll() {
//
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		System.out.println("Server Connection successfully established through retrieve all.");
//		DB dbs = mongoClient.getDB("mydb");
//
//		DBCollection col = dbs.getCollection("Employee");
//		// MongoCollection<Document> col = (MongoCollection<Document>)
//		// dbs.getCollection("Employee");
//		// List<Document> docs = coll.find().into(new ArrayList<Document>());
//
//		Cursor cursor = col.find();
//
//		List<Employee> EmployeeList = new ArrayList<Employee>();
//
//		while (cursor.hasNext()) {
//
//			DBObject obj = cursor.next();
//			Employee u1 = new Employee(obj.get("name").toString(), obj.get("password").toString());
//			System.out.println(obj.get("name") + " - " + obj.get("password"));
//			EmployeeList.add(u1);
//
//		}
//
//		mongoClient.close();
//
//		return EmployeeList;
//		
//	}
//
//	// Updating password for a Employee in a document. Create the updated Document object
//	
//	public static void updatePassword(String name, String password) {
//
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//		DB dbs = mongoClient.getDB("mydb");
//
//		DBCollection col = dbs.getCollection("Employee");
//
//		col.find();
//
//		if (EmployeeDoesExist(name, password)) {
//			System.out.println("Employee \"" + name + "\" already exists.");
//
//		} else {
//			BasicDBObject updatedDocument = new BasicDBObject();
//
//			// New value to be added in the document
//			updatedDocument.put("name", name);
//			updatedDocument.put("password", password);
//
//			// Specifying old document to be updated.
//			BasicDBObject oldDocument = new BasicDBObject("name", name);
//			
//			if (updatedDocument.get("name").equals(oldDocument.get("name"))) {
//				
//				col.update(oldDocument, updatedDocument, false, false);
//				System.out.println(
//						"Document updated:: From - " + oldDocument.toString() + " To -" + updatedDocument.toString());
//			
//			}
//		}
//		mongoClient.close();
//
//	}
//
//	// Document deletion
//	public static void remove(String name, String password) {
//
//		MongoClient mongoClient = new MongoClient("localhost", 27017);
//
//		DB dbs = mongoClient.getDB("mydb");
//
//		DBCollection col = dbs.getCollection("Employee");
//
//		BasicDBObject document = new BasicDBObject();
//		document.put("name", name);
//		document.put("password", password);
//		col.remove(document);
//		System.out.println("Document Deleted for " + name);
//		
//		mongoClient.close();
//
//	}
//}
