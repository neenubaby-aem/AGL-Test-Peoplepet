package com.model;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJsonToList {

	private static final Logger LOG = Logger.getLogger(ParseJsonToList.class.getName());
	/**
	 * This method parses the Json and returns list of cats
	 * whose owners are male.
	 * @param jsonString
	 * @return maleOwnerCatList
	 */
	public static List<String> getCatsofMaleOwners(final String jsonString) {
		
		List<String> maleOwnerCatList = new LinkedList<String>();
		try{
			final JSONArray jsonStringArray = new JSONArray(jsonString);
			for (int index = 0; index < jsonStringArray.length(); index++) {
				final JSONObject jsonStringArrayObject = jsonStringArray.getJSONObject(index);
				final String ownerGender = (String) jsonStringArrayObject.get(ProgramConstants.OWNER_GENDER);
				if (ownerGender.equalsIgnoreCase(ProgramConstants.MALE_GENDER)) {

					final String jsonStringOfPets = jsonStringArrayObject.get(ProgramConstants.PETS).toString();
					
					if (null != jsonStringArrayObject && !(jsonStringOfPets.equalsIgnoreCase(ProgramConstants.NULL_STRING))) {
						final JSONArray arrayOfPets = jsonStringArrayObject.getJSONArray(ProgramConstants.PETS);
						
						for (int indexLoop = 0; indexLoop < arrayOfPets.length(); indexLoop++) {
							final JSONObject jsonArrayPets = arrayOfPets.getJSONObject(indexLoop);
							final String typeofPet = (String) jsonArrayPets.get(ProgramConstants.PET_TYPE);
							if (!typeofPet.isEmpty()) {
								if (typeofPet.equalsIgnoreCase(ProgramConstants.CAT_TYPE_PET)) {
									final String catName = (String) jsonArrayPets.get(ProgramConstants.NAME_OF_PET);
									maleOwnerCatList.add(catName);
								}
							}
						}
					}
				}
			}
		} catch(Exception e) {
			LOG.info("Error Occured in Method:getCatsofMaleOwners of <class:ParseJsonToList>");
		}

		return maleOwnerCatList;
	}

	/**
	 * Method returns a list of cats whose owners are female
	 * @param json
	 * @return List<String>
	 */
	public static List<String> getCatsOfFemaleOwners(final String json) {
		
		List<String> femaleOwnerCatList = new LinkedList<String>();
		try {
			final JSONArray jsonArray = new JSONArray(json);
			for (int index = 0; index < jsonArray.length(); index++) {
				final JSONObject jsonObject = jsonArray.getJSONObject(index);
				final String owner_gender = (String) jsonObject.get(ProgramConstants.OWNER_GENDER);
				if (owner_gender.equalsIgnoreCase(ProgramConstants.FEMALE_GENDER)) {

					final String pets = jsonObject.get(ProgramConstants.PETS).toString();
					if (null != jsonObject && !(pets.equalsIgnoreCase(ProgramConstants.NULL_STRING))) {
						final JSONArray arrayOfPets = jsonObject.getJSONArray(ProgramConstants.PETS);
						for (int indexLoop = 0; indexLoop < arrayOfPets.length(); indexLoop++) {
							final JSONObject jsonArrayPets = arrayOfPets.getJSONObject(indexLoop);
							final String typeofPet = (String) jsonArrayPets.get(ProgramConstants.PET_TYPE);
							if (!typeofPet.isEmpty()) {
								if (typeofPet.equalsIgnoreCase(ProgramConstants.CAT_TYPE_PET)) {
									final String catName = (String) jsonArrayPets.get(ProgramConstants.NAME_OF_PET);
									femaleOwnerCatList.add(catName);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			LOG.info("Error Occured in Method:getCatsofFemaleOwners of <class:ParseJsonToList>");
		}
	
		return femaleOwnerCatList;
	}
}