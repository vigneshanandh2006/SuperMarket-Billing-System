package com.vignesh;

public class User {

	private String email;
	private String password;
	private String role;
	private double deposit;
	public User(String email,String password,String role) {
		this.email=email;
		this.password=password;
		this.role=role;
		this.deposit=1000.00;
	}
	public String getRole()
	{
		return role;
	}
	public String getemail()
	{
		return email;
	}
	public String getPass()
	{
		return password;
	}
	public double getDeposit()
	{
		return deposit;
	}

}
