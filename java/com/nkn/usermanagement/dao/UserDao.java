package com.nkn.usermanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.DBObject;
import com.nkn.usermanagement.bean.User;

public class UserDao {
		
	
	
		public void connect() {
			//Establishing connection with server
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			System.out.println("Server Connection successfully established");	
			
			//Connecting with database. Creates the database if it doesn't exist.
			DB dbs = mongoClient.getDB("mydb");
			System.out.println("Connection to DB successful");
			System.out.println("Database Name: " + dbs.getName()); // Get DB Name
			
			//Create a collection if it doesn't already exist
			DBCollection col = dbs.getCollection("user");
		}
			
		
		//Insert a document in a collection
		public static void insert(String name, String password) {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB dbs = mongoClient.getDB("mydb");
			
			DBCollection col = dbs.getCollection("user"); 
			
		    BasicDBObject doc = new BasicDBObject();

		    doc.put("name",name);
		    doc.put("password",password);		    
			
	//		BasicDBObject doc1 = new BasicDBObject("Name", Name).append("Password", Password);
			col.insert(doc);
			System.out.println("Document Inserted");
		}

		//Read Operation. Create a cursor to pass through each document
		
		public static List<User> retrieveAll() {
			
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			System.out.println("Server Connection successfully established through retrieve all.");
			DB dbs = mongoClient.getDB("mydb");
			
			DBCollection col = dbs.getCollection("user");
			//MongoCollection<Document> coll = (MongoCollection<Document>) dbs.getCollection("user");
			//List<Document> docs = coll.find().into(new ArrayList<Document>());
			
			Cursor cursor = col.find();
			
			List<User> l = new ArrayList<User>();
			
			  while (cursor.hasNext()) {
			  
			  DBObject obj = cursor.next();
			  User u1 =  new User( obj.get("name").toString() , obj.get("password").toString());
			  System.out.println(obj.get("name") + " - " + obj.get("password") ); 
			  l.add(u1);
			  
			  }
			 
		
			return l;
		}
		
		//Update a document. Create the updated Document object
		 public static void updatePassword(String name, String password){
			  
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			
			DB dbs = mongoClient.getDB("mydb");
			
			DBCollection col = dbs.getCollection("user");
			BasicDBObject updatedDocument = new BasicDBObject();
			
			//New value in document
			updatedDocument.put("password", password);
			
			//Specify old Document to be updated.
			BasicDBObject oldDocument = new BasicDBObject().append("name", name);
			col.update(oldDocument, updatedDocument, false, false);
			System.out.println("Document updated:: From - " +oldDocument.toString() + " To -" + updatedDocument.toString());
			
			  }	
		
		//Document deletion
		public static void remove(String name, String password) {
			
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			
			DB dbs = mongoClient.getDB("mydb");
			
			DBCollection col = dbs.getCollection("user");
			
			BasicDBObject document = new BasicDBObject();
			document.put("name", name);
			document.put("password", password);
			col.remove(document);
			System.out.println("Document Deleted for " +name);
		}
}
		

	
