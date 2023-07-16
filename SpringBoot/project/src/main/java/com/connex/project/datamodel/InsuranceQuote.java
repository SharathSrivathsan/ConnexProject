package com.connex.project.datamodel;

public class InsuranceQuote
{
	private boolean isAvailable;
	private Double premium;
	private String reference;
	private String message;

	public boolean isAvailable()
	{
		return isAvailable;
	}
	public void setAvailable(final boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}
	public Double getPremium()
	{
		return premium;
	}
	public void setPremium(final Double premium)
	{
		this.premium = premium;
	}
	public String getReference()
	{
		return reference;
	}
	public void setReference(final String reference)
	{
		this.reference = reference;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(final String message)
	{
		this.message = message;
	}
}
