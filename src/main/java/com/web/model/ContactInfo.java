package com.web.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class ContactInfo {
	
	private String email;
    private String phoneNumber;
    
    @Embedded
    private PresentAddress address;

	public ContactInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactInfo(String email, String phoneNumber, PresentAddress address) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PresentAddress getAddress() {
		return address;
	}

	public void setAddress(PresentAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ContactInfo [email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
    
    

}
