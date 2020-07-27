package com.java.model;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


public class Database {
	
	static MongoClient mongo;
	static DB db;
	static DBCollection feeds;  
	
	public static void dbConnect() { 
		mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("CITIBRIDGE1");
	}
	
	public static DBCollection feedsCollection() { 
		feeds = db.getCollection("FEED FILE");
		return feeds;
	}
	
	
}
