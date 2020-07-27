package com.java;
import java.io.*;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import au.com.bytecode.opencsv.CSVReader;
import com.java.Transaction;
import com.java.TransactionDate;

public class InputReading 
{
	static MongoClient mongo;
	static DB db;
	static DBCollection feed,collection2,collection3;
	
	public static TransactionDate parseDate(String dateString) {
		int day, month, year;
		// Date Format DD/MM/YYYY thus 2,2,4 split of dateString
		day = Integer.parseInt(dateString.substring(0, 2));
		month = Integer.parseInt(dateString.substring(3, 5));
		year = Integer.parseInt(dateString.substring(6, 10));
		return (new TransactionDate(day, month, year));
	}
    public static void main(String[] args) throws FileNotFoundException 
    {
    	 mongo = new MongoClient("localhost", 27017);
         
         db = mongo.getDB("CITIBRIDGE1");  //Database initialization
         System.out.println("Connection to MongoDB database successfully");
         feed = db.getCollection("FEED FILE");
         collection2 = db.getCollection("PASSED TRANSACTIONS");
         collection3 = db.getCollection("FAILED TRANSACTIONS");

        WriteResult result1 = feed.remove(new BasicDBObject());
 		WriteResult result2 = collection2.remove(new BasicDBObject());
 		WriteResult result3 = collection3.remove(new BasicDBObject());
         String TRID, DATE,PRNAME,PRACC,PNAME,PACC,AMT,ST;
        
        try { 
        	  
            // Create an object of filereader 
            // class with CSV file as a parameter. 
            FileReader filereader = new FileReader("C:\\Users\\DELL\\Citibridge\\Feed\\src\\main\\resources\\SAMPLE INPUT FILE.csv");  
      
            // create csvReader object passing 
            // file reader as a parameter 
            CSVReader csvReader = new CSVReader(filereader); 
            String[] values; 
      
            // we are going to read data line by line 
            while ((values = csvReader.readNext()) != null) { 
            	TRID=values[0];
                DATE=values[1];
                PRNAME=values[2];
                PRACC=values[3];
                PNAME=values[4];
                PACC=values[5];
                AMT=values[6];
                Transaction t=new Transaction();
             t.setTransactionRef(TRID);
       		 t.setTransactionDate(parseDate(DATE));
       		 t.setPayerName(PRNAME);
       		 t.setPayerAccount(PRACC);
       		 t.setPayeeName(PNAME);
       		 t.setPayeeAccount(PACC);
       		 t.setTransactionAmount(Double.valueOf(AMT));//?check Datatype changes 00 truncation
       		
                int flag=test(t);
               InputReading.CollectionAllotment(t, flag);
               
            } 
          
        } 
        
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
   }
    public static int test(Transaction t)
	{
	
		int flag=0;
		Parameters P=new Parameters();
		P.TRID (t.getTransactionRef(),12);
		P.date(t);
		P.PRNAME (t.getPayerName(),35);
		P.PRACC(t.getPayerAccount(),12);
		P.PNAME (t.getPayeeName(),35);
		P.PACC (t.getPayeeAccount(),12);
		P.AMT (t.getTransactionAmount());
		flag=P.test();
		return flag;
		
	}
    
    
    
    public static void CollectionAllotment(Transaction t,int flag) //alot status based on file value
    {
    	if(flag==7)
    	{
    		t.setFeedStatus("PASSED");
    	    Collectioninsertion(collection2,t);
    	}
    	else
    	{
    		t.setFeedStatus("FAILED");
            Collectioninsertion(collection3,t);
        }
    	
    }
 
public static void Collectioninsertion(DBCollection collection,Transaction t) //insert into alloted collection
{
	Gson gson=new Gson();
	
	String json = gson.toJson(t);
    // Parse to bson document and insert
	BasicDBObject doc = BasicDBObject.parse(json);
	System.out.println(doc);
	collection.insert(doc);
	feed.insert(doc);
} 

public static ArrayList<Object> getFeedList()
{
	 DBCursor cursorObj =feed.find();
	 ArrayList<Object> feedList=new ArrayList<>();

	    try {
	        while(cursorObj.hasNext()) {
	        	feedList.add(cursorObj.next());
	        }
	        return feedList;
	    } 
	    catch(Exception e) {
	    	System.out.print(e.getMessage());
	    	return feedList;
	    }
	finally {
	        cursorObj.close();
	}

}
}

