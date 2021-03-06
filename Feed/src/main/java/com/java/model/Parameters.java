package com.java.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Parameters 
{
 boolean invalid=false;
 boolean occurenceflag;
 static int statusflag=0;

	 public Parameters()
	 {
		 this.statusflag=0;
	 }
		public boolean TRID(String TRID,int length) //check length of trnasaction id
		{
			String n=TRID;
			
			if(n.length()==length && n.matches("[a-zA-Z0-9]+"))
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
			
		}
		public TransactionDate parseDate(String dateString) {
			int day, month, year;
			// Date Format DD/MM/YYYY thus 2,2,4 split of dateString
			day = Integer.parseInt(dateString.substring(0, 2));
			month = Integer.parseInt(dateString.substring(3, 5));
			year = Integer.parseInt(dateString.substring(6, 10));
			return (new TransactionDate(day, month, year));
		}
	
		public  boolean PRNAME(String PRNAME, int length) //check length of PAYER NAME
		{
			String n=PRNAME;
			
			if(n.length()<=length && n.matches("[a-zA-Z0-9]+"))
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
		}
		
		
		public boolean PRACC(String PRACC, int length) //check length of Payer Account no
		{

			String n=PRACC;
			
			if(n.length()==length && n.matches("[a-zA-Z0-9]+"))
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
		}
		
		public boolean PNAME(String PNAME,int length) //check length of Payee name
		{
			String n=PNAME;
			if(n.length()<=length && n.matches("[a-zA-Z0-9]+"))
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
		}
		
		
		public boolean PACC(String PACC,int length) //check length of Payee account number
		{
			String n=PACC;
			if(n.length()==length && n.matches("[a-zA-Z0-9]+"))
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
		}
		
		public  boolean AMT(Double AMT)  //check account number
		{
			double n=AMT;
				if(n>0.00 && n<9999999999.99)
				{
				statusflag=statusflag+1;
				return true;
				}
				return false;
		}	
		

		public  boolean date(Transaction t) //check date
		{
			boolean f;
			String dateobj=t.getTransactionDate();
			TransactionDate date=parseDate(dateobj);
			f=checkDate(date);
			if(f)
			{
				statusflag=statusflag+1;
				return true;
			}
			return false;
		}

		public  boolean checkDate(TransactionDate transactionDate) {
			return checkDateFormat(transactionDate.getDay(), transactionDate.getMonth(), transactionDate.getYear())
					&& checkTransactionOccuranceDate(transactionDate.getDay(), transactionDate.getMonth(),
							transactionDate.getYear());

		}

		public boolean checkDateFormat(int day, int month, int year) //check date format
		{

			if (year > 9999 || year < 1000)
				invalid= true;
			if (month > 12 || month < 1) {
				invalid = true;
			}
			if (checkDay(day, month, year) == false) {
				invalid = true;
			}
			if (invalid==false)
				occurenceflag=checkTransactionOccuranceDate(day, month, year);
			
			if(invalid==false && occurenceflag==true)
				return true;
			else
				return false;
			
		}

		public static boolean checkDay(int day, int month, int year) //check day
		{                                      
			if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
					&& (day > 0 && day <= 31))
				return true;
			else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 0 && day <= 30))
				return true;
			else if ((year % 4 != 0 && day > 0 && day <= 28) || (year % 4 == 0 && day > 0 && day <= 29))
				return true;
			return false;
		}

		public static boolean checkTransactionOccuranceDate(int day, int month, int year) //check date occurence-transaction is happening only on the current date
		{
			Date currentDate = new Date();
			int currentDay = currentDate.getDate();
			int currentMonth = currentDate.getMonth() + 1;
			int currentYear = currentDate.getYear() + 1900;
			// System.out.println("\nCurrent : " + currentDay + currentMonth + currentYear +
			// "\nTransaction Date : " + day
			// + month + year);

			if (day < currentDay || month < currentMonth || year < currentYear) {
				//dateBeforeFlag = true;// transactionDate before currentDate
				return false;
			} else if (day > currentDay || month > currentMonth || year > currentYear) {
				//dateAfterFlag = true;// transactionDate after currentDate
				return false;
			}
			return true;
		}

		public int test()
		{
			return statusflag;
		}
		
}


