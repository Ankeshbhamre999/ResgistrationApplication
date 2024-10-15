package com.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Education {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degree;
    private String fieldOfStudy;
    private String institution;
    private int startYear;
    private int endYear;
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(Long id, String degree, String fieldOfStudy, String institution, int startYear, int endYear) {
		super();
		this.id = id;
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.institution = institution;
		this.startYear = startYear;
		this.endYear = endYear;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", degree=" + degree + ", fieldOfStudy=" + fieldOfStudy + ", institution="
				+ institution + ", startYear=" + startYear + ", endYear=" + endYear + "]";
	}
    

	
	
}
