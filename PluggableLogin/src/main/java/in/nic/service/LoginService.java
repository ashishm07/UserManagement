package in.nic.service;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import in.nic.entity.Login;
import in.nic.entity.LoginMap;

public class LoginService {

	// Establishing connection with server
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB dbs = mongoClient.getDB("mydb");

//	BasicDBObject doc = new BasicDBObject();
	// mongoClient.close();

	public String newUser(Login user) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserIdByLoginType(LoginMap loginMap) {
		String userid = "";
		DBCollection col = dbs.getCollection("userProfileMap");
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("loginID", loginMap.getLoginID());
		whereQuery.put("LoginType", loginMap.getLoginType());
		DBCursor cursor = col.find(whereQuery);
		//DBCursor cursor = col.find();
		try {
			
			    
			while (cursor.hasNext()) {
				System.out.println("chk point 5");
				DBObject obj = cursor.next();
				System.out.println("User exists");
				userid = obj.get("userID").toString();
				System.out.println("userID" + userid);
				break;

			}
			 System.out.println("chk point 5");} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			mongoClient.close();
			System.out.println("Done");
		}
		return userid;
	}

	public boolean checkUser(String userID, String password) {
		DBCollection col = dbs.getCollection("userProfile");
		Cursor cursor = col.find();
		boolean userExists = false;
		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				Login u1 = new Login(obj.get("userID").toString(), obj.get("password").toString());
				if ((userID.equals(u1.getName())) && (password.equals(u1.getPassword()))) {
					System.out.println("User exists");
					userExists = true;
					break;
				}
			}
		} catch (Exception e) {
			userExists = false;
			e.printStackTrace();

		} finally {
			mongoClient.close();
			System.out.println("Done");
		}

		return userExists;
	}

}
