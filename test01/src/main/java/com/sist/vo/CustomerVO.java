
package com.sist.vo;

public class CustomerVO {
	private int custid;
	private String name;
	private String address;
	private String phone;
	private String fname;
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public CustomerVO(int custid, String name, String address, String phone, String fname) {
		super();
		this.custid = custid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fname = fname;
	}
	public CustomerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
