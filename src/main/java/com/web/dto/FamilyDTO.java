package com.web.dto;

import java.util.List;

import com.web.model.PrimaryMember;

import lombok.Data;

@Data
public class FamilyDTO {
    private String familyName;
    private String address;
    private String city;
    private String phoneNumber;
    private PrimaryMember primaryMember;
    //private Long primaryMemberId;
    private List<MemberDTO> members;
	public FamilyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilyDTO(String familyName, String address, String city, String phoneNumber, PrimaryMember primaryMember,
			List<MemberDTO> members) {
		super();
		this.familyName = familyName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.primaryMember = primaryMember;
		this.members = members;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public PrimaryMember getPrimaryMember() {
		return primaryMember;
	}
	public void setPrimaryMember(PrimaryMember primaryMember) {
		this.primaryMember = primaryMember;
	}
	public List<MemberDTO> getMembers() {
		return members;
	}
	public void setMembers(List<MemberDTO> members) {
		this.members = members;
	}
	@Override
	public String toString() {
		return "FamilyDTO [familyName=" + familyName + ", address=" + address + ", city=" + city + ", phoneNumber="
				+ phoneNumber + ", primaryMember=" + primaryMember + ", members=" + members + "]";
	}
    
    
   
}
