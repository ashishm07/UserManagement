package in.nic;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBObject;


public class EmployeeDao{
	
	static List<Employee> EmployeeList = new ArrayList<Employee>();
	
	public EmployeeDao() {
		
		System.out.println("---");
		
	}
	public List<Employee> getEmployees(){
			return retrieveAll(); 
	}
		
	public Employee getEmployee(int eNumber) {
			

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Server Connection successfully established through retrieve all.");
		DB dbs = mongoClient.getDB("newdb");

		DBCollection col = dbs.getCollection("Employee");
 		Cursor cursor = col.find();

		List<Employee> EmployeeList = new ArrayList<Employee>();

		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			Employee emp1 = new Employee(obj.get("name").toString(), Integer.parseInt(obj.get("id").toString()) );
			
			if (eNumber== Integer.parseInt( obj.get("id").toString()))
			{
				return emp1;
			}
			
			EmployeeList.add(emp1);
		}
		mongoClient.close();

		return new Employee();

	}
	
	public static void create(Employee[] e) {
		try {
			
			for (Employee e1 : e) {
			String name = e1.getName();
			int id = e1.getid();
			
			insert(name, id);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void connect() {
		// Establishing  with server
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Server Connection successfully established");
		
		// Connecting with database. Creates the database if it doesn't exist.
		DB dbs = mongoClient.getDB( "newdb" );
		System.out.println("Connection to DB successful");
		System.out.println("Database Name: " + dbs.getName()); // Get DB Name

		//Creates a collection with given name if the collection does not already exist.
		DBCollection col = dbs.getCollection("Employee");
	

		Cursor cursor = col.find();

//		BasicDBObject doc = new BasicDBObject();
//
//		doc.put("name", "Mycroft");
//		doc.put("id", 222);
//
//		col.insert(doc);
//		System.out.println("Document Inserted");
		
//		List<Employee> EmployeeList = new ArrayList<Employee>();

		
		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			//Employee u1 = new Employee(obj.get("name").toString(), Integer.parseInt(obj.get("id").toString()) );
			//System.out.println(obj.get("name") + " - " + obj.get("id"));
			//EmployeeList.add(u1);
			System.out.println("Name : " + obj.get("name") + " ID :" +obj.get("id") );
		}

		mongoClient.close();
	}

	// To check if Employee already exists
	public static boolean EmployeeDoesExist(String name, int id) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB dbs = mongoClient.getDB("newdb");

		System.out.println("Connection to DB successful");
		
		DBCollection col = dbs.getCollection("Employee");

		Employee newEmployee = new Employee(name, id);

		Cursor cursor = col.find();

		boolean EmployeeExists = false;

		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			Employee u1 = new Employee(obj.get("name").toString(), (int)Float.parseFloat(obj.get("id").toString()) );
			if ((newEmployee.getName().equals(u1.getName())) && (newEmployee.getid()==(u1.getid()))) {
				System.out.println("Employee exists");
				EmployeeExists = true;
				break;
			}
		}
		mongoClient.close();

		return EmployeeExists;
	}

	// Inserting a document in a collection
	public static void insert(String name, int id) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB dbs = mongoClient.getDB("newdb");

		DBCollection col = dbs.getCollection("Employee");

		if (EmployeeDoesExist(name, id)) {
			System.out.println("Employee \"" + name + "\" already exists.");
		} else {
			BasicDBObject doc = new BasicDBObject();

			doc.put("name", name);
			doc.put("id", id);

			col.insert(doc);
			System.out.println("Document Inserted");
		}
		
		mongoClient.close();
	}

	// Read Operation. Create a cursor object to pass through each document
	public static List<Employee> retrieveAll() {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Server Connection successfully established through retrieve all.");
		DB dbs = mongoClient.getDB("newdb");

		DBCollection col = dbs.getCollection("Employee");
		// MongoCollection<Document> col = (MongoCollection<Document>)
		// dbs.getCollection("Employee");
		// List<Document> docs = coll.find().into(new ArrayList<Document>());

		Cursor cursor = col.find();


		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			Employee u1 = new Employee(obj.get("name").toString(), Integer.parseInt(obj.get("id").toString()) );
			System.out.println(obj.get("name") + " - " + obj.get("id"));
			EmployeeList.add(u1);
		}

		mongoClient.close();

//		for (Employee e: EmployeeList) {
//			
//			System.out.println(e + " employee ");
//		}
//		
		return EmployeeList;		
	}

	// Updating id for a Employee in a document. Create the updated Document object
	
	public static void updateId(String name, int id) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB dbs = mongoClient.getDB("newdb");

		DBCollection col = dbs.getCollection("Employee");

		col.find();

		if (EmployeeDoesExist(name, id)) {
			System.out.println("Employee \"" + name + "\" already exists.");

		} else {
			BasicDBObject updatedDocument = new BasicDBObject();

			// New value to be added in the document
			updatedDocument.put("name", name);
			updatedDocument.put("id", id);

			// Specifying old document to be updated.
			BasicDBObject oldDocument = new BasicDBObject("name", name);
			
			if (updatedDocument.get("name").equals(oldDocument.get("name"))) {
				
				col.update(oldDocument, updatedDocument, false, false);
				System.out.println(
						"Document updated:: From - " + oldDocument.toString() + " To -" + updatedDocument.toString());
			}
		}
		mongoClient.close();

	}

	// Document deletion
	public static void remove(String name, int id) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB dbs = mongoClient.getDB("newdb");

		DBCollection col = dbs.getCollection("Employee");

		BasicDBObject document = new BasicDBObject();
		document.put("name", name);
		document.put("id", id);
		col.remove(document);
		System.out.println("Document Deleted for " + name);
		
		mongoClient.close();

	}

}