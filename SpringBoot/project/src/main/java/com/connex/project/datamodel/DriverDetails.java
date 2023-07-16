package com.connex.project.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DriverDetails
{
	@NotNull
	@Min(value=16, message="{age.min}")
	@Max(value=120, message="{age.max}")
	@JsonProperty("age")
	private Integer age;

	@NotNull
	@Min(value=0, message="{experience.min}")
	@Max(value=100, message="{experience.max}")
	@JsonProperty("experience")
	private Integer experience;

	@NotNull
	@Min(value=0, message="{record.min}")
	@Max(value=1000, message="{record.max}")
	@JsonProperty("record")
	private Integer record;

	@NotNull
	@Min(value=0, message="{claims.min}")
	@Max(value=1000, message="{claims.max}")
	@JsonProperty("claims")
	private Integer claims;

	@NotNull
	@Min(value=0, message="{carvalue.min}")
	@Max(value=9999999, message="{carvalue.max}")
	@JsonProperty("car_value")
	private Long carValue;

	@NotNull
	@Min(value=0, message="{carmileage.min}")
	@Max(value=999999, message="{carmileage.max}")
	@JsonProperty("car_annual_mileage")
	private Long carAnnualMileage;

	@NotNull
	@Min(value=0, message="{insurancehistory.min}")
	@Max(value=100, message="{insurancehistory.max}")
	@JsonProperty("insurance_history")
	private Integer insuranceHistory;

	public Integer getAge()
	{
		return age;
	}
	public void setAge(final Integer age)
	{
		this.age = age;
	}
	public Integer getExperience()
	{
		return experience;
	}
	public void setExperience(final Integer experience)
	{
		this.experience = experience;
	}
	public Integer getRecord()
	{
		return record;
	}
	public void setRecord(final Integer record)
	{
		this.record = record;
	}
	public Integer getClaims()
	{
		return claims;
	}
	public void setClaims(final Integer claims)
	{
		this.claims = claims;
	}
	public Long getCarValue()
	{
		return carValue;
	}
	public void setCarValue(final Long carValue)
	{
		this.carValue = carValue;
	}
	public Long getCarAnnualMileage()
	{
		return carAnnualMileage;
	}
	public void setCarAnnualMileage(final Long carAnnualMileage)
	{
		this.carAnnualMileage = carAnnualMileage;
	}
	public Integer getInsuranceHistory()
	{
		return insuranceHistory;
	}
	public void setInsuranceHistory(final Integer insuranceHistory)
	{
		this.insuranceHistory = insuranceHistory;
	}
}
