package com.vignesh;
import java.util.*;
public class Inventory {

	ArrayList<product>pr=new ArrayList<>();
	public void additems(String name,double price,int id,int quant)
	{
		product p=new product(name,id,price,quant);
		pr.add(p);
		System.out.println("Items added Succesfully");
	}
	public void showitems()
	{
		if(pr.isEmpty())
		{
			System.out.println("No items");
		}
		else
		{
			for(product pro:pr)
			{
				pro.display();
				
			}
		}
	}
	public void SearchItem(String name,int ID)
	{
		boolean found=false;
		for(product pro:pr)
		{
			if(pro.getPNmae().equals(name) && pro.getID()==ID)
			{
				found=true;
				System.out.println("Yes!! the item in the list");
				pro.display();
				break;
			}
		}
		if(!found)
		{
			System.out.println("No!! item not here");
		}
	}
	public void ModifyItems(int id,double newprice,int newquantity)
	{
		for(product pro:pr)
		{
			if(pro.getID()==id)
			{
				pro.SetPrice(newprice);
				pro.Setquant(newquantity);
				System.out.println("Modified Successfully");
			}
			else
			{
				System.out.println("That product is not in the list");
			}
		}
	}
	public void DeleteItem(String name,int ID)
	{
		boolean found=false;
		for(product pro:pr)
		{
			if(pro.getPNmae().equals(name) && pro.getID()==ID)
			{
				found=true;
				pr.remove(pro);
				System.out.println("Item Deleted Successfully");
				break;
			}
			
		}
		if(!found)
		{
			System.out.println("That item is not in the list");
		}
	}
}
