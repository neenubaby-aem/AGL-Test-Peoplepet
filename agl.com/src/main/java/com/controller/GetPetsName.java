package com.controller;

import java.util.logging.Logger;

import com.model.ParseJsonToList;
import com.model.ReadJsonUrl;
import com.view.DisplayCats;

public class GetPetsName {
	
	private static final Logger LOG = Logger.getLogger(GetPetsName.class.getName());
	
	public static void getListOfPetNames() {
		try{
			
			String json = ReadJsonUrl.readUrl("http://agl-developer-test.azurewebsites.net/people.json");
			DisplayCats.displayListOfCats(ParseJsonToList.getCatsofMaleOwners(json), ParseJsonToList.getCatsOfFemaleOwners(json));
		} catch (Exception e){
			LOG.info("Exception in the method GetListOfPetNames() <class:getPetsName>");
		}
	}
}