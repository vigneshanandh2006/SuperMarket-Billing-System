package com.vignesh;
import java.util.*;
public class bill {

	private int billNumber;
	private String billdate;
	ArrayList<cart>ca;
	private String customeremail;
	private double totalamount;
	public bill(int billno,String billdate,String customeremail,ArrayList<cart>ca,double total) {
		// TODO Auto-generated constructor stub
		this.billNumber=billno;
		this.billdate=billdate;
		this.ca=ca;
		this.customeremail=customeremail;
		this.totalamount=total;
	}
	public int getBillno()
	{
		return billNumber;
	}
	public String getBillDate() {
		return billdate;
	}
	public double getTotal()
	{
		return totalamount;
	}
	public String getcustomeremail()
	{
		return customeremail;
	}
	public void display()
	{
		System.out.println("Bill Number: " + billNumber);
	    System.out.println("Date: " + billdate);
	    System.out.println("Customer: " + customeremail);
	    System.out.println("Items purchased:");
	    for(cart c : ca) {
	        c.displaycart();
	}
	    System.out.println("Total Amount: Rs." + totalamount);
	    System.out.println("================================");
	}

}
