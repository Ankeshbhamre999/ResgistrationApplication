package com.web.dto;

import java.util.List;

import com.web.model.ContactInfo;

import lombok.Data;

@Data
public class MemberDTO {
    private String name;
    private int age;
    private String gender;
    private String relation;
    private String profession;
    private boolean isPrimary;       
    private String maritalStatus;
    private String nationality;
    private List<String> languagesSpoken;
    private ContactInfo contactInfo;
    
    
    private List<EducationDTO> educationList;


	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MemberDTO(String name, int age, String gender, String relation, String profession, boolean isPrimary,
			String maritalStatus, String nationality, List<String> languagesSpoken, ContactInfo contactInfo,
			List<EducationDTO> educationList) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.relation = relation;
		this.profession = profession;
		this.isPrimary = isPrimary;
		this.maritalStatus = maritalStatus;
		this.nationality = nationality;
		this.languagesSpoken = languagesSpoken;
		this.contactInfo = contactInfo;
		this.educationList = educationList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public boolean isPrimary() {
		return isPrimary;
	}


	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public List<String> getLanguagesSpoken() {
		return languagesSpoken;
	}


	public void setLanguagesSpoken(List<String> languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}


	public ContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}


	public List<EducationDTO> getEducationList() {
		return educationList;
	}


	public void setEducationList(List<EducationDTO> educationList) {
		this.educationList = educationList;
	}


	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + ", gender=" + gender + ", relation=" + relation
				+ ", profession=" + profession + ", isPrimary=" + isPrimary + ", maritalStatus=" + maritalStatus
				+ ", nationality=" + nationality + ", languagesSpoken=" + languagesSpoken + ", contactInfo="
				+ contactInfo + ", educationList=" + educationList + "]";
	}
    
    
}
