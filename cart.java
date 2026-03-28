package com.vignesh;

public class cart {

	private product p;
	private int quantity;
	public cart(product p,int quantity) {
		// TODO Auto-generated constructor stub
		this.p=p;
		this.quantity=quantity;
		}
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	public product getProduct() {
	    return p;
	}

	public int getQuantity() {
	    return quantity;
	}
	
	public void displaycart()
	{
		System.out.println("Product Name: " + p.getPNmae());
	    System.out.println("Quantity: " + quantity);
	    System.out.println("Price each: " + p.getPrice());
	    System.out.println("Total: " + (p.getPrice() * quantity));
	    System.out.println("------------------");
	}
}
