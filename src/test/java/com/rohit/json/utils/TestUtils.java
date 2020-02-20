package com.rohit.json.utils;

import java.util.LinkedList;
import java.util.List;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class TestUtils {

	protected static Associates getAssociates() {
		Associates associates = new Associates();
		List<Associate> listOfAssociates = new LinkedList<>();
        listOfAssociates.add(JsonUtilities.createAssociate("Name1","123"));
        listOfAssociates.add(JsonUtilities.createAssociate("Name2","456"));
        associates.setAssociates(listOfAssociates);
		return associates;
	}
	
	protected static Associates getModifiedAssociates() {
		Associates associates = new Associates();
		List<Associate> listOfAssociates = new LinkedList<>();
        listOfAssociates.add(JsonUtilities.createAssociate("Name1","123"));
        listOfAssociates.add(JsonUtilities.createAssociate("Name3","789"));
        associates.setAssociates(listOfAssociates);
		return associates;
	}
	
	protected static Associate getAssociate() {
		Associate associate = new Associate();
		associate.setId("123");
		associate.setName("Name1");
		return associate;
	}
	
}
