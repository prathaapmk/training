package com.training.learning.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

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
		age = ageLogic();
		experience =expLogic();
	}
	
	public int ageLogic()
	{
		/*
		 * DateTimeFormatter dfm =
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.000Z "); LocalDateTime l =
		 * LocalDateTime.now();
		 * 
		 * LocalDateTime oldDate = LocalDateTime.parse(dob, dfm); Duration d =
		 * Duration.between(l, oldDate); int days =(int) (d.toHours()/24);
		 */
		
		return 29;
		
	}
	public int expLogic()
	{
		
		/*
		 * DateTimeFormatter dfm =
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss.0 "); LocalDateTime l =
		 * LocalDateTime.now();
		 * 
		 * LocalDateTime oldDate = LocalDateTime.parse(joiningDate, dfm); Duration d =
		 * Duration.between(l, oldDate); int days =(int) (d.toHours()/24);
		 */
		return 2;
		
	}
	

}
