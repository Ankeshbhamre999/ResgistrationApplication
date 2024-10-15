package com.web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="FamilyRegistration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Family {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String familyName;
	    private String address;
	    private String city;
	    private String phoneNumber;
	    //private Long primaryMemberId;
	    
	    
	    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Member> members = new ArrayList<>();
	    
	    // One-to-One relationship with PrimaryMember
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "primary_member_id", referencedColumnName = "id")
	    private PrimaryMember primaryMember;

		public Family() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Family(Long id, String familyName, String address, String city, String phoneNumber, List<Member> members,
				PrimaryMember primaryMember) {
			super();
			this.id = id;
			this.familyName = familyName;
			this.address = address;
			this.city = city;
			this.phoneNumber = phoneNumber;
			this.members = members;
			this.primaryMember = primaryMember;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public List<Member> getMembers() {
			return members;
		}

		public void setMembers(List<Member> members) {
			this.members = members;
		}

		public PrimaryMember getPrimaryMember() {
			return primaryMember;
		}

		public void setPrimaryMember(PrimaryMember primaryMember) {
			this.primaryMember = primaryMember;
		}

		@Override
		public String toString() {
			return "Family [id=" + id + ", familyName=" + familyName + ", address=" + address + ", city=" + city
					+ ", phoneNumber=" + phoneNumber + ", members=" + members + ", primaryMember=" + primaryMember
					+ "]";
		}

	    

	    
}
