package com.web.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PresentAddress {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
	public PresentAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PresentAddress(String street, String city, String state, String zipCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "PresentAddress [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", country=" + country + "]";
	}
    
    
	
}
