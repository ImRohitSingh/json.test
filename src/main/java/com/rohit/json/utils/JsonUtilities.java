package com.rohit.json.utils;

import java.util.List;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class JsonUtilities {

	private JsonUtilities() throws IllegalAccessException {
		throw new IllegalAccessException("Access methods in static way");
	}
	
	public static Associate createAssociate(String name,String id) {
		Associate associate = new Associate();
		associate.setName(name);
		associate.setId(id);
		return associate;
	}
	
	public static Associates createListOfAssociates(List<Associate> listOfAssociates) {
		Associates associates = new Associates();
		associates.setAssociates(listOfAssociates);;
		return associates;
	}
	
}
