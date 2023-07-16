package com.connex.project.datamodel;

public class ApplicationConstants
{

	private static float NOT_APPLICABLE = 0f;

	public static String BASE_PREMIUM_URI = "https://storage.googleapis.com/connex-th/insurance_assignment/base_premium.json";
	public static String BASE_PREMIUM_KEY = "base_premium";
	public static String PREMIUM_SUCCESS_MSG = "Your premium has been calculated!";
	public static String PREMIUM_EXCEPTION_MSG = "Premium could not be determined. Please contact our insurance specialist!";

	public static float AGE_LESS_THAN_25 = 1.3f;
	public static float AGE_BETWEEN_25_40 = 1f;
	public static float AGE_BETWEEN_40_70 = 0.9f;
	public static float AGE_GREATER_THAN_70 = NOT_APPLICABLE;

	public static float EXPERIENCE_LESS_THAN_2 = 1.5f;
	public static float EXPERIENCE_BETWEEN_2_5 = 1.3f;
	public static float EXPERIENCE_BETWEEN_5_10 = 1f;
	public static float EXPERIENCE_GREATER_THAN_10 = 0.9f;

	public static float RECORD_0 = 1f;
	public static float RECORD_1 = 1.1f;
	public static float RECORD_2_3 = 1.3f;
	public static float RECORD_GREATER_THAN_3 = NOT_APPLICABLE;

	public static float CLAIMS_0 = 0.9f;
	public static float CLAIMS_1 = 1.2f;
	public static float CLAIMS_2_3 = 1.5f;
	public static float CLAIMS_GREATER_THAN_3 = NOT_APPLICABLE;

	public static float VALUE_LESS_THAN_30K = 0.8f;
	public static float VALUE_BETWEEN_30K_60K = 1f;
	public static float VALUE_BETWEEN_60K_100K = 1.2f;
	public static float VALUE_BETWEEN_100K_150K = 1.5f;
	public static float VALUE_BETWEEN_150K_200K = 2f;
	public static float VALUE_GREATER_THAN_200K = NOT_APPLICABLE;
	
	public static float MILEAGE_LESS_THAN_20K = 0.9f;
	public static float MILEAGE_BETWEEN_20K_30K = 1f;
	public static float MILEAGE_BETWEEN_30K_50K = 1.1f;
	public static float MILEAGE_GREATER_THAN_50K = 1.3f;
	
	public static float HISTORY_0 = 1.2f;
	public static float HISTORY_WITHIN_2 = 1.1f;
	public static float HISTORY_GREATER_THAN_2 = 1f;
}
