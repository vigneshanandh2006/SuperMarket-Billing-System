package com.vignesh;

public class product {
	 private String productName;
	 private int productID;
	 private double price;
	private int quantity;
	
	public product(String name,int id,double price,int quantity) {
		this.productName=name;
		this.productID=id;
		this.price=price;
		this.quantity=quantity;
		// TODO Auto-generated constructor stub
	}
	public void setName(String name)
	{
		this.productName=name;
	}
	public void SetId(int ID)
	{
		this.productID=ID;
	}
	public void SetPrice(double price)
	{
		this.price=price;
	}
	public void Setquant(int quant)
	{
		this.quantity=quant;
	}
	
	public String getPNmae()
	{
		return productName;
	}
	public int getID()
	{
		return productID;
	}
	public double getPrice()
	{
		return price;
	}
	public int getQuan()
	{
		return quantity;
	}
	public void display()
	{
		System.out.println("Product Name:"+productName+"\nProduct ID:"+productID+"\nPrice:"+price+"\nquantity:"+quantity);
	}

}
