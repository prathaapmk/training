package com.training.learning.core.models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.joda.time.LocalDate;

@Model(adaptables = Resource.class)
public class UserDetailsModel {

	@ValueMapValue
	private String fname;

	@ValueMapValue
	private String lname;

	@ValueMapValue
	private String dob;
	@ValueMapValue
	private String compname;
	@ValueMapValue
	private String joiningDate;
	@ValueMapValue
	private String biodata;
	
	private int age;
	
	private int experience;

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getDob() {
		return dob;
	}

	public String getCompname() {
		return compname;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public String getBiodata() {
		return biodata;
	}

	public int getAge() {
		return age;
	}

	public int getExperience() {
		return experience;
	}
	
	@PostConstruct
	public void init()
	{
		/*age = ageLogic();
		experience =expLogic(); */
		
		age = globalLogic(dob);
		experience=globalLogic(joiningDate);
		
	}
	
	public int ageLogic()
	{
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			
		LocalDateTime oldDate = LocalDateTime.parse(dob, dfm);
		LocalDateTime l = LocalDateTime.now();
		Duration d = Duration.between(oldDate,l);
		int days =(int) (d.toHours()/24);
		
		return days/365;
		
	}
	public int expLogic()
	{
		
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		
		LocalDateTime oldDate = LocalDateTime.parse(joiningDate, dfm);
		LocalDateTime l = LocalDateTime.now();
		Duration d = Duration.between(oldDate,l);
		int days =(int) (d.toHours()/24);
		return days/365;
		
	}
	
	public int globalLogic(String joindate)
	{
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		
		LocalDateTime oldDate = LocalDateTime.parse(joindate, dfm);
		LocalDateTime l = LocalDateTime.now();
		Duration d = Duration.between(oldDate,l);
		int days =(int) (d.toHours()/24);
		return days/365;
		
	}
	

}
