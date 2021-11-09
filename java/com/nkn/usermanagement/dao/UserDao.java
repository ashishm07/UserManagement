package com.nkn.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBObject;
import com.nkn.usermanagement.bean.User;

@SuppressWarnings( "deprecation" )
public class UserDao {

	public void connect() {
		// Establishing connection with server
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Server Connection successfully established");

		// Connecting with database. Creates the database if it doesn't exist.
		DB dbs = mongoClient.getDB("mydb");
		System.out.println("Connection to DB successful");
		System.out.println("Database Name: " + dbs.getName()); // Get DB Name

		//Creates a collection with given name if the collection does not already exist.
		dbs.getCollection("user");
		mongoClient.close();

	}

	// To check if user already exists
	public static boolean userDoesExist(String name, String password) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB dbs = mongoClient.getDB("mydb");

		DBCollection col = dbs.getCollection("user");

		User newUser = new User(name, password);

		Cursor cursor = col.find();

		boolean userExists = false;

		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			User u1 = new User(obj.get("name").toString(), obj.get("password").toString());
			if ((newUser.getName().equals(u1.getName())) && (newUser.getPassword().equals(u1.getPassword()))) {
				userExists = true;
				break;
			}
		}
		mongoClient.close();

		return userExists;
	}

	// Inserting a document in a collection
	public static void insert(String name, String password) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB dbs = mongoClient.getDB("mydb");

		DBCollection col = dbs.getCollection("user");

		if (userDoesExist(name, password)) {
			System.out.println("User \"" + name + "\" already exists.");
		} else {
			BasicDBObject doc = new BasicDBObject();

			doc.put("name", name);
			doc.put("password", password);

			col.insert(doc);
			System.out.println("Document Inserted");
		}
		
		mongoClient.close();

	}

	// Read Operation. Create a cursor object to pass through each document
	public static List<User> retrieveAll() {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		System.out.println("Server Connection successfully established through retrieve all.");
		DB dbs = mongoClient.getDB("mydb");

		DBCollection col = dbs.getCollection("user");
		// MongoCollection<Document> col = (MongoCollection<Document>)
		// dbs.getCollection("user");
		// List<Document> docs = coll.find().into(new ArrayList<Document>());

		Cursor cursor = col.find();

		List<User> userList = new ArrayList<User>();

		while (cursor.hasNext()) {

			DBObject obj = cursor.next();
			User u1 = new User(obj.get("name").toString(), obj.get("password").toString());
			System.out.println(obj.get("name") + " - " + obj.get("password"));
			userList.add(u1);

		}

		mongoClient.close();

		return userList;
		
	}

	// Updating password for a user in a document. Create the updated Document object
	
	public static void updatePassword(String name, String password) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB dbs = mongoClient.getDB("mydb");

		DBCollection col = dbs.getCollection("user");

		col.find();

		if (userDoesExist(name, password)) {
			System.out.println("User \"" + name + "\" already exists.");

		} else {
			BasicDBObject updatedDocument = new BasicDBObject();

			// New value to be added in the document
			updatedDocument.put("name", name);
			updatedDocument.put("password", password);

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
	public static void remove(String name, String password) {

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		DB dbs = mongoClient.getDB("mydb");

		DBCollection col = dbs.getCollection("user");

		BasicDBObject document = new BasicDBObject();
		document.put("name", name);
		document.put("password", password);
		col.remove(document);
		System.out.println("Document Deleted for " + name);
		
		mongoClient.close();

	}
}
