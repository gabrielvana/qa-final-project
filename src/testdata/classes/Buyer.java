package testdata.classes;

import utils.Reader;

public class Buyer {
	
	private String firstname;
	private String lastname;
	private String postalcode;
	private String payment;
	private String shipping;

	
	public Buyer (String filename) {
	
	this.firstname = Reader.json(filename).get("firstname").toString();
	this.lastname = Reader.json(filename).get("lastname").toString();
	this.postalcode = Reader.json(filename).get("postalcode").toString();
	this.payment = Reader.json(filename).get("payment").toString();
	this.shipping = Reader.json(filename).get("shipping").toString();
	
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	

}
