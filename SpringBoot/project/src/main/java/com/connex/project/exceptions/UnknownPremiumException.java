package com.connex.project.exceptions;

public class UnknownPremiumException extends Exception
{ 
	private static final long serialVersionUID = 1L;

	public UnknownPremiumException (String str)  
    {  
        super(str);  
    }  
}
