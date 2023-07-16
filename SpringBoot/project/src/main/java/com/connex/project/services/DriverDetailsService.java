package com.connex.project.services;

import java.util.UUID;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.connex.project.datamodel.DriverDetails;
import com.connex.project.datamodel.ApplicationConstants;
import com.connex.project.exceptions.UnknownPremiumException;

public class DriverDetailsService
{
	private DriverDetails driverDetails = null;

	public DriverDetailsService(DriverDetails details)
	{
		this.driverDetails = details;
	}

	public DriverDetails getDriverDetails()
	{
		return this.driverDetails;
	}

    public Double getBasePremium()
    {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(ApplicationConstants.BASE_PREMIUM_URI, String.class);
        JSONObject json = new JSONObject(result);
        return json.getDouble(ApplicationConstants.BASE_PREMIUM_KEY);
    }

    public String getQuoteReference()
    {
    	return UUID.randomUUID().toString().substring(0, 7).toUpperCase();
    }

    public Double getFactoredPremium() throws UnknownPremiumException
    {
    	return (double) Math.round(getOverallFactor() * getBasePremium() * 100) / 100;
    }

    public Float getOverallFactor() throws UnknownPremiumException
    {
    	return (getAgeFactor() + getExperienceFactor() + getRecordFactor() + getClaimsFactor()
    			+ getValueFactor() + getMileageFactor() + getHistoryFactor()) / 7;
    }

    public Boolean checkFeasibility(final Float factor) throws UnknownPremiumException
    {
    	if (factor != 0)
    		return true;
    	else 
    		throw new UnknownPremiumException(ApplicationConstants.PREMIUM_EXCEPTION_MSG);
    }

    public Float getAgeFactor() throws UnknownPremiumException
    {
    	Integer age = this.getDriverDetails().getAge();
    	Float age_factor = 0f;
    	if(age < 25)
    		age_factor = ApplicationConstants.AGE_LESS_THAN_25;
    	else if(age >= 25 && age < 40)
    		age_factor = ApplicationConstants.AGE_BETWEEN_25_40;
    	else if(age >= 40 && age < 70)
    		age_factor = ApplicationConstants.AGE_BETWEEN_40_70;
    	else
    		age_factor = ApplicationConstants.AGE_GREATER_THAN_70;

    	checkFeasibility(age_factor);
    	return age_factor;
    }

    public Float getExperienceFactor() throws UnknownPremiumException
    {
    	Integer experience = this.getDriverDetails().getExperience();
    	Float experience_factor = 0f;
    	if(experience < 2)
    		experience_factor = ApplicationConstants.EXPERIENCE_LESS_THAN_2;
    	else if(experience >= 2 && experience < 5)
    		experience_factor = ApplicationConstants.EXPERIENCE_BETWEEN_2_5;
    	else if(experience >= 5 && experience < 10)
    		experience_factor = ApplicationConstants.EXPERIENCE_BETWEEN_5_10;
    	else
    		experience_factor = ApplicationConstants.EXPERIENCE_GREATER_THAN_10;

    	checkFeasibility(experience_factor);
    	return experience_factor;
    }

    public Float getRecordFactor() throws UnknownPremiumException
    {
    	Integer record = this.getDriverDetails().getRecord();
    	Float record_factor = 0f;
    	if(record == 0)
    		record_factor = ApplicationConstants.RECORD_0;
    	else if(record == 1)
    		record_factor = ApplicationConstants.RECORD_1;
    	else if(record == 2 || record == 3)
    		record_factor = ApplicationConstants.RECORD_2_3;
    	else if(record > 3)
    		record_factor = ApplicationConstants.RECORD_GREATER_THAN_3;

    	checkFeasibility(record_factor);
    	return record_factor;
    }

    public Float getClaimsFactor() throws UnknownPremiumException
    {
    	Integer claims = this.getDriverDetails().getClaims();
    	Float claims_factor = 0f;
    	if(claims == 0)
    		claims_factor = ApplicationConstants.CLAIMS_0;
    	else if(claims == 1)
    		claims_factor = ApplicationConstants.CLAIMS_1;
    	else if(claims == 2 || claims == 3)
    		claims_factor = ApplicationConstants.CLAIMS_2_3;
    	else if(claims > 3)
    		claims_factor = ApplicationConstants.CLAIMS_GREATER_THAN_3;

    	checkFeasibility(claims_factor);
    	return claims_factor;
    }

    public Float getValueFactor() throws UnknownPremiumException
    {
    	Long value = this.getDriverDetails().getCarValue();
    	Float value_factor = 0f;
    	if(value < 30000)
    		value_factor = ApplicationConstants.VALUE_LESS_THAN_30K;
    	else if(value >= 30000 && value < 60000)
    		value_factor = ApplicationConstants.VALUE_BETWEEN_30K_60K;
    	else if(value >= 60000 && value < 100000)
    		value_factor = ApplicationConstants.VALUE_BETWEEN_60K_100K;
    	else if(value >= 100000 && value < 150000)
    		value_factor = ApplicationConstants.VALUE_BETWEEN_100K_150K;
    	else if(value >= 150000 && value < 200000)
    		value_factor = ApplicationConstants.VALUE_BETWEEN_150K_200K;
    	else
    		value_factor = ApplicationConstants.VALUE_GREATER_THAN_200K;
    	
    	checkFeasibility(value_factor);
    	return value_factor;
    }

    public Float getMileageFactor() throws UnknownPremiumException
    {
    	Long mileage = this.getDriverDetails().getCarAnnualMileage();
    	Float mileage_factor = 0f;
    	if(mileage < 20000)
    		mileage_factor = ApplicationConstants.MILEAGE_LESS_THAN_20K;
    	else if(mileage >= 20000 && mileage < 30000)
    		mileage_factor = ApplicationConstants.MILEAGE_BETWEEN_20K_30K;
    	else if(mileage >= 30000 && mileage < 50000)
    		mileage_factor = ApplicationConstants.MILEAGE_BETWEEN_30K_50K;
    	else
    		mileage_factor = ApplicationConstants.MILEAGE_GREATER_THAN_50K;

    	checkFeasibility(mileage_factor);
    	return mileage_factor;
    }

    public Float getHistoryFactor() throws UnknownPremiumException
    {
    	Integer history = this.getDriverDetails().getInsuranceHistory();
    	Float history_factor = 0f;
    	if(history == 0)
    		history_factor = ApplicationConstants.HISTORY_0;
    	else if(history <= 2)
    		history_factor = ApplicationConstants.HISTORY_WITHIN_2;
    	else if(history > 2)
    		history_factor = ApplicationConstants.HISTORY_GREATER_THAN_2;

    	checkFeasibility(history_factor);
    	return history_factor;
    }
}
