package com.connex.project.restservice;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.connex.project.datamodel.ApplicationConstants;
import com.connex.project.datamodel.DriverDetails;
import com.connex.project.datamodel.InsuranceQuote;
import com.connex.project.exceptions.UnknownPremiumException;
import com.connex.project.services.DriverDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestServiceController
{
	private DriverDetailsService driverService = null;

	public DriverDetailsService getDriverService()
	{
		return this.driverService;
	}

	public void initializeDriverService(final DriverDetails driverDetails)
	{
		this.driverService = new DriverDetailsService(driverDetails);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/quote", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InsuranceQuote> getQuote(@Valid @RequestBody final DriverDetails driver, BindingResult result) throws ParseException
	{
		InsuranceQuote quote = new InsuranceQuote();
		this.initializeDriverService(driver);
		if(result.hasErrors())
		{
			List<String> errorMessages = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
			quote.setAvailable(false);
			quote.setMessage(errorMessages.toString());
		}
		else
		{
			try
			{
				quote.setPremium(getDriverService().getFactoredPremium());
				quote.setAvailable(true);
				quote.setMessage(ApplicationConstants.PREMIUM_SUCCESS_MSG);
			}
			catch(UnknownPremiumException exception)
			{
				quote.setAvailable(false);
				quote.setMessage(exception.getMessage());
			}
		}
		quote.setReference(getDriverService().getQuoteReference());
		return new ResponseEntity<InsuranceQuote>(quote, HttpStatus.CREATED);
	}
}
