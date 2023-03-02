package com.prakruthi;

public class Account {
	private String name;
	private String mobileno;
	private String Accountno;
	private String ifsc;
	static String bankname="Prakruthi Bank";
	private double bal;
	private int pin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Account(String name, String mobileno, String accountno, String ifsc, double bal , int pin) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		Accountno = accountno;
		this.ifsc = ifsc;
		this.bal = bal;
		this.pin=pin;
	}
	public void showdetails() {

	}
	public double deposit(double amount) {
		if(amount>0) {
			bal=bal+amount;
			return bal;
		}
		return bal;
	}
	public double withdraw(double amount) {
		if(bal>amount) {
			bal=bal-amount;
			return bal;
		}
		return 0;
	}
	public String transfer(String mobileno ,int pin) {
		if(pin==this.pin) {
			return mobileno;
		}
		return null;
	}





}
