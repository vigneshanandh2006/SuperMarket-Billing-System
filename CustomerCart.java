package com.vignesh;
import java.util.*;
public class CustomerCart {
	ArrayList <product>prr=new ArrayList<>();
	ArrayList<cart>ca=new ArrayList<>();
	public CustomerCart(ArrayList<product>p) {
		// TODO Auto-generated constructor stub
		this.prr=p; 	
	}
	public void viewProduct()
	{
		
		if(prr.isEmpty())
		{
			System.out.println("No items in the cart");
		}
		else {
		for(product cc:prr)
		{
			System.out.println("The list of items in the cart is");
			cc.display();
		}
		}
	}
		public void addtoCart(int id,int quantity)
		{
			boolean yes= false;
			for(product p:prr)
			{
				if(p.getID()==id)
				{
					yes=true;
					if(p.getQuan()>=quantity)
					{
						cart c=new cart(p,quantity);
						ca.add(c);
						System.out.println("Item added to cart");
					}
					else
					{
						System.out.println("No, there is less quantity");
					}
					break;
			}
			}
				if(!yes)
				{
					System.out.println("That item is not in the list");
				}
			}
		public void viewcart()
		{
			if(ca.isEmpty())
			{
				System.out.println("The cart is empty");
			}
			else {
			for(cart c:ca)
			{
				c.displaycart();
			}
			}
		}
		public void removeitem(int id)
		{
			boolean there=false;
			for(cart c:ca)
			{
				if(c.getProduct().getID()==id)
				{
					there=true;
					ca.remove(c);
					break;
				}
				
			}
			if(!there)
			{
				System.out.println("That item is not in the cart");
			}
			
		}
		public void editItem(int id,int newQuant)
		{
			boolean found=false;
			for(cart c:ca)
			{
				if(c.getProduct().getID()==id)
				{
					found = true;
					c.setQuantity(newQuant);
					break;
				}
			}
			if(!found)
			{
				System.out.println("That item is not in the cart");
			}
		}

}
