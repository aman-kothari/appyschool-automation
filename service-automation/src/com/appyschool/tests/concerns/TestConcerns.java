package com.appyschool.tests.concerns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.appyschool.common.CommonMethods;
import com.appyschool.common.CommonUtils;
import com.appyschool.common.ConfigProperties;
import com.appyschool.common.DataProviderArguments;
import com.appyschool.common.GenericConstants;
import com.appyschool.common.SoftAssertionBase;
import com.appyschool.common.SuiteSetupProperties;
import com.appyschool.services.ConcernsServices;
import com.jayway.restassured.response.Response;	

public class TestConcerns extends SoftAssertionBase{

	/**
	 * Create Concerns
	 * 
	 * @param map
	 * @throws JSONException
	 */
	@Test(dataProviderClass = com.appyschool.common.CommonUtils.class, dataProvider = "getDataFromFile")
	@DataProviderArguments("./testData/csv/Concerns.csv")
	public void testCreateConcerns(HashMap<String, String> map) throws JSONException {
		int n=1;
		String jsonTemplate = ConfigProperties.getValue(GenericConstants.CONCERNS_CREATE_PAYLOAD);
		
		map.put("$studentid", SuiteSetupProperties.getValue("STUDENT_ID_"+n));
		map.put("$staffid", SuiteSetupProperties.getValue("Staff_ID"));
		
		JSONObject json = CommonUtils.getJsonFromTemplate(jsonTemplate, map);
		
		json.put("title", RandomStringUtils.randomAlphanumeric(10));
		json.put("actionTaken","NO");
		json.put("version",1);
		
		System.out.println(json.toString());
		Response response = ConcernsServices.createConcerns(json.toString());
		response.then().log().all();

		JSONObject responseObj = new JSONObject(response.getBody().asString());
		verifyEquals(response.statusCode(), 200);
		verifyEquals(responseObj.getString("status"), GenericConstants.SUCCESS_OK);
		n++;
	}
	
	/**
	 * Modify Concerns
	 * 
	 * @param map
	 * @throws JSONException
	 */
	@Test(dataProviderClass = com.appyschool.common.CommonUtils.class, dataProvider = "getDataFromFile")
	@DataProviderArguments("./testData/csv/Concerns.csv")
	public void testModifyConcerns(HashMap<String, String> map) throws JSONException {
		List<String> ids= CommonMethods.createConcerns();
		if (ids != null) {
			String jsonTemplate = ConfigProperties.getValue(GenericConstants.CONCERNS_CREATE_PAYLOAD);

			JSONObject json = CommonUtils.getJsonFromTemplate(jsonTemplate, map);
			
			json.put("title","MODIFIED"+ RandomStringUtils.randomAlphanumeric(10));
			json.put("description", "Modified from API automation");
			json.put("id", ids.get(0));
			json.put("actionTaken",RandomStringUtils.randomAlphabetic(5)+"   "+RandomStringUtils.randomAlphabetic(5));
			json.put("version",1);
			json.put("complaintState","ACTIONTAKEN");
			
			Response response = ConcernsServices.modifyConcerns(json.toString());
			response.then().log().all();
			verifyEquals(response.statusCode(), 200);
		}
		else {
			verifyTrue(false);
		}
	}


	/**
	 * Get All Concerns Details
	 * 
	 * @param map
	 * @throws JSONException
	 */
	@Test()
	public void testGetallConcernsDetails() throws JSONException {
		
			Response response = ConcernsServices.getAllConcerns();
			response.then().log().all();
			
			verifyEquals(response.statusCode(), 200);
	}
	
}
