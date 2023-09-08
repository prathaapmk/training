package com.training.learning.core.models;



import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = MyFirstSlingModel.RESOURCE_TYPE)
@Exporter(name="jackson",extensions = "json")
public class MyFirstSlingModel {
	
	  public final static String RESOURCE_TYPE = "/apps/training/components/myfirstslingmodelcomponent";
	@ValueMapValue
	private String firstName ;
	
	@ValueMapValue
	private String  lastName ;
	
	@ValueMapValue
	private String text;
	
	@ValueMapValue
	private String[] studentName;
	
	 @ChildResource
	    private List<CountryProps> countryProps;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String[] getStudentName() {
		return studentName;
	}

	public String getText() {
		return text;
	}

	public List<CountryProps> getCountryProps() {
		return countryProps;
	}
	

	
	

}
