package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PrimaryMember {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private int age;
	    private String gender;
	    private String relation;
	    private String profession;
		public PrimaryMember() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PrimaryMember(Long id, String name, int age, String gender, String relation, String profession) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.relation = relation;
			this.profession = profession;
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
		@Override
		public String toString() {
			return "PrimaryMember [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", relation="
					+ relation + ", profession=" + profession + "]";
		}
	    
	    
}
