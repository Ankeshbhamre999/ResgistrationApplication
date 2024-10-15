package com.web.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private int age;
	    private String gender;
	    private String relation;
	    private String profession;
	    
	    private boolean isPrimary;
	    private String maritalStatus;  
	    private String nationality;
	    
	    @ElementCollection
	    private List<String> languagesSpoken;
	    
	    @Embedded
	    private ContactInfo contactInfo;
	    
	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    @JoinColumn(name = "member_id")
	    private List<Education> educationList;
	    
	    @ManyToOne
	    @JoinColumn(name = "family_id")
	    private Family family;

		public Member() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Member(Long id, String name, int age, String gender, String relation, String profession,
				boolean isPrimary, String maritalStatus, String nationality, List<String> languagesSpoken,
				ContactInfo contactInfo, List<Education> educationList, Family family) {
			super();
			this.id = id;
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
			this.family = family;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public List<Education> getEducationList() {
			return educationList;
		}

		public void setEducationList(List<Education> educationList) {
			this.educationList = educationList;
		}

		public Family getFamily() {
			return family;
		}

		public void setFamily(Family family) {
			this.family = family;
		}

		@Override
		public String toString() {
			return "Member [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", relation="
					+ relation + ", profession=" + profession + ", isPrimary=" + isPrimary + ", maritalStatus="
					+ maritalStatus + ", nationality=" + nationality + ", languagesSpoken=" + languagesSpoken
					+ ", contactInfo=" + contactInfo + ", educationList=" + educationList + ", family=" + family + "]";
		}
	    

}
