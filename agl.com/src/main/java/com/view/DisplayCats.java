package com.view;

import java.util.List;

public class DisplayCats {

	public static void displayListOfCats(List<String> catListMale, List<String> catListFemale){
		
		System.out.println("Male\n");
		for(String catName: catListMale) {
			System.out.println(catName);
		}
		
		System.out.println("\nFemale\n");
		for(String catName: catListFemale){
			System.out.println(catName);
		}
		
	}
}
