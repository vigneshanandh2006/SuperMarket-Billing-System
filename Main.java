package com.vignesh;
import java.util.*;
public class Main {
public static void main(String[] args) {
	ArrayList<User>u=new ArrayList<>();
	ArrayList<bill>b=new ArrayList<>();
	Scanner sc= new Scanner(System.in);
	Inventory in=new Inventory();
	CustomerCart c=new CustomerCart(in.pr);
	while(true) {
	System.out.println("=============Welcome to KPN Super Market=================\n1.Register\n2.Login");
	System.out.println("Enter your choice");
	int choice=sc.nextInt();
	sc.nextLine();
	
	if(choice==1) {
		System.out.println("Enter your role");
		String role=sc.nextLine();
	System.out.println("Enter your email");
	String email=sc.nextLine();
	System.out.println("Enter your Password");
	String pass=sc.nextLine();
	User uss=new User(email,pass,role,"self");
	u.add(uss);
	System.out.println("Registered Successfully");
	}
	if(choice==2)
	{
		System.out.println("Enter your role");
		String role=sc.nextLine();
		
		boolean found=false;
		System.out.println("Enter your email");
		String email=sc.nextLine();
		System.out.println("Enter your password");
		String pass=sc.nextLine();
		User loggedInUser = null;
		for(User user : u) {
		    if(user.getemail().equals(email) && user.getPass().equals(pass)) {
		        found = true;
		        loggedInUser = user; 
		        if(role.equals("Admin")) {
		            System.out.println("Welcome Admin!\nLogin Successfully");
		        } else if(role.equals("Customer")) {
		            System.out.println("Welcome Customer!\nLogin Successfully");
		        }
		        break;
		    }
		}
		
		if(!found)
		{
			System.out.println("Invalid Creditenials");
		}
		
	if(found && role.equals("Admin"))
	{
		while(true) {
		System.out.println("=====Admin access=====\n1.Add Items\n2.Search Items\n3.Modify Items\n4.Show Items\n5.Add Customers\n.6Reports\7.Exit");
		System.out.println("Enter the admin choice");
		int AdminChoice=sc.nextInt();
		if(AdminChoice==1) {
		System.out.println("Enter the name of the product");
		String name=sc.nextLine();
		System.out.println("Enter the Id of the product");
		int id=sc.nextInt();
		System.out.println("Enter the price of the product");
		double price=sc.nextDouble();
		System.out.println("Enter the quantity of the product");
		int quantity=sc.nextInt();
		sc.nextLine();
		in.additems(name, price, id, quantity);
		}
	if(AdminChoice==2 )
	{
		System.out.println("Enter the product name to be searched");
		String name=sc.nextLine();
		System.out.println("Enter the id of the product");
		int id=sc.nextInt();
		sc.nextLine();
		in.SearchItem(name, id);
	}
	if(AdminChoice==3)
	{
		System.out.println("Enter the product id to modify");
		int id=sc.nextInt();
		System.out.println("Enter the new price");
		double newprice=sc.nextDouble();
		System.out.println("Enter the new Quantity");
		int newQuant=sc.nextInt();
		sc.nextLine();
		in.ModifyItems(id, newprice, newQuant);
		
	}
	if(AdminChoice==4 )
	{
		System.out.println("The products are");
		in.showitems();
	}
	if(AdminChoice==5)
	{
		System.out.println("Enter the customers email");
		String cmail=sc.nextLine();
		System.out.println("Enter the customer password");
		String cpass=sc.nextLine();
		User use=new User(cmail,cpass,"Customer",loggedInUser.getemail());
		u.add(use);
		System.out.println("Customer added successfully");
		
	}
	if(AdminChoice == 6) {
	    Report r = new Report(in.pr, u, b);
	    System.out.println("1.Low Stock\n2.Never Bought\n3.Top Customers\n4.Top Admins");
	    int repChoice = sc.nextInt();
	    sc.nextLine();
	    if(repChoice == 1) { r.stockproducts(5); }
	    if(repChoice == 2) { r.neverBoughtProducts(); }
	    if(repChoice == 3) { r.topCustomers(); }
	    if(repChoice == 4) { r.topAdmins(); }
	}
	if(AdminChoice == 7) {
	    System.out.println("====Thank You====");
	    break;
	}
		}
	}
	if(found && role.equals("Customer"))
	{
		while(true) {
		System.out.println("======WELCOME CUSTOMER======\nMenu.\n1.View list of products in the store\n2.Add items to the cart\n3.Remove item from cart\n4.Edit item quantity\n5.view items in the cart\n.6.Payment process\n7.Exit");
		System.out.println("Enter the choice");
		int customerchoice=sc.nextInt();
		if(customerchoice==1)
		{
			c.viewProduct();
		}
		if(customerchoice==2)
		{
			System.out.println("Enter the product id");
			int id=sc.nextInt();
			System.out.println("Enter the number of quantity");
			int quantity=sc.nextInt();
			c.addtoCart(id, quantity);
		}
		if(customerchoice==3)
		{
			System.out.println("Enter the product id to remove from the cart");
			int id=sc.nextInt();
			c.removeitem(id);
		}
		if(customerchoice==4)
		{
			System.out.println("Enter the product id to edit in the cart");
			int id=sc.nextInt();
			System.out.println("Enter the new Qunatity for that product");
			int newQuant=sc.nextInt();
			c.editItem(id, newQuant);
		}
		if(customerchoice==5)
		{
			c.viewcart();
		}
		if(customerchoice==6)
		{
			Payment p=new Payment(c.ca,loggedInUser,b);
			p.processpayment();
		}
		if(customerchoice==7)
		{
			for(bill bi:b)
			{
				if(bi.getcustomeremail().equals(loggedInUser.getemail()))
				{
					bi.display();
				}
			}
		}
		if(customerchoice==8)
		{
			System.out.println("Thank you");
			break;
		}
		sc.close();
		}
		
	}
}
	
}

}
}
