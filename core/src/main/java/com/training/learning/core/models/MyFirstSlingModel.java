package com.training.learning.core.models;



import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.training.learning.core.services.CheckOSGIConfigs;
import com.training.learning.core.services.SampleInterface;
import com.training.learning.core.services.SimpleServiceForCallingService;

@Model(adaptables = SlingHttpServletRequest.class, adapters = SomeMethodsInterface.class, defaultInjectionStrategy   = DefaultInjectionStrategy.OPTIONAL,resourceType = MyFirstSlingModel.RESOURCE_TYPE)
@Exporter(name="jackson",extensions = "json")
public class MyFirstSlingModel implements SomeMethodsInterface{
	
	@SlingObject
	ResourceResolver rr;
	@ScriptVariable
	SlingHttpServletRequest request;
	
	@OSGiService
	CheckOSGIConfigs checkOSgiConfig;
	
	private String payment;
	
	@RequestAttribute
	private String first;
	
	  public final static String RESOURCE_TYPE = "/apps/training/components/myfirstslingmodelcomponent";
	  
	  private String nameFromService;
	@ValueMapValue
	private String firstName ;
	
	@ValueMapValue
	private String  lastName ;
	
	@ValueMapValue
	private String text;
	
	@ValueMapValue(name = "dob")
	private String somdob;
	
	@ValueMapValue
	private String[] studentName;
	
	 @ChildResource
	    private List<CountryProps> countryProps;


	public String[] getStudentName() {
		return studentName;
	}

	public String getText() {
		return text;
	}

	public List<CountryProps> getCountryProps() {
		return countryProps;
	}
	
	
	@OSGiService
	SimpleServiceForCallingService smi;
	
	public String getSomdob() {
		return somdob;
	}



	private OffsetDateTime noDays;

	@PostConstruct
	public void init()
	{
		
		/*
		 * String authAddedDate = dob; // String strDateTime = //
		 * "Tue Jun 29 15:37:43 GMT+05:30 2021"; DateTimeFormatter dtfInput =
		 * DateTimeFormatter.ofPattern("E MMM d H:m:s O u", Locale.ENGLISH);
		 * OffsetDateTime formatedDate= OffsetDateTime.parse(authAddedDate, dtfInput);
		 * noDays=formatedDate;
		 */
		 
		nameFromService = smi.callaSpecificService();
		payment=checkOSgiConfig.readOSGI();
		
	}

	public static String getResourceType() {
		return RESOURCE_TYPE;
	}

	public OffsetDateTime getNoDays() {
		return noDays;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getFirst() {
		return first;
	}

	public String getNameFromService() {
		return nameFromService;
	}

	public String getPayment() {
		return payment;
	}

	
	
	

}
