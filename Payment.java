package com.vignesh;
import java.util.*;
public class Payment {
	  ArrayList<cart> c;
	    User customer;
	    
	    public Payment(ArrayList<cart> c, User customer) {
	        this.c = c;
	        this.customer = customer;
	    }
	public void processpayment() {
		double total=0;
	for(cart ca:c)
	{
	 total+=ca.getProduct().getPrice()*ca.getQuantity();
	}
	if(customer.getDeposit()>=total) {
	if(total>=5000)
	{
		double remains=customer.getDeposit()-total;
		
		customer.setDeposit(remains+100);
		System.out.println("Congratulations Rs.100 is credited to your deposit as a cashback");
	}
	else if(customer.getPoint()>=50)
	{
		total=total-100;
		System.out.println("The Amount to pay is Rs."+total);
		double remains=customer.getDeposit()-total;
		customer.setDeposit(remains);
		System.out.println("Rs.100 Deduction from your total price");
		customer.setPoint(0);
	}
	else
	{
		int point=(int)(total/100);
		customer.setPoint(customer.getPoint()+point);
		System.out.println("Your earned totally "+customer.getPoint()+" Points.");
		customer.setDeposit(customer.getDeposit()-total);
	}
	}
	else
	{
		System.out.println("Insufficient Balance");
	}
	

}
}
