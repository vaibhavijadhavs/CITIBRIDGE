package com.java.model;

import java.util.Date;

public class Transaction {
	private String TRID;
	private String PRNAME;
	private String PRACC;
	private String PNAME;
	private String PACC;
	private double AMT; // ?find the datatype signed|unsigned
	private String ST;
	private String transactionDate;
	
	
	public String isFeedStatus() {
		return ST;
	}

	public void setFeedStatus(String feedStatus) {
		this.ST = feedStatus;
	}

	public String getTransactionRef() {
		return TRID;
	}

	public void setTransactionRef(String transactionRef) {
		this.TRID = transactionRef;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return  TRID + " " + transactionDate
				+ " " + PRNAME + PRACC + " " + PNAME + PACC
				+ " " + AMT + " " + ST +"\n";
	}

	public String inputToString() {
		return "TransactionParameters [transactionRef=" + TRID + ", transactionDate=" + transactionDate.toString()
				+ ", payerName=" + PRNAME + ", payerAccount=" + PRACC + ", payeeName=" + PNAME
				+ ", payeeAccount=" + PACC + ", transactionAmount=" + AMT + "]";
	}

	public String getPayerName() {
		return PRNAME;
	}

	public void setPayerName(String payerName) {
		this.PRNAME = payerName;
	}

	public String getPayerAccount() {
		return PRACC;
	}

	public void setPayerAccount(String payerAccount) {
		this.PRACC = payerAccount;
	}

	public String getPayeeName() {
		return PNAME;
	}

	public void setPayeeName(String payeeName) {
		this.PNAME = payeeName;
	}

	public String getPayeeAccount() {
		return PACC;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.PACC = payeeAccount;
	}

	public double getTransactionAmount() {
		return AMT;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.AMT = transactionAmount;
	}

}
/*
 * private int day; private int month; private int year;
 */
