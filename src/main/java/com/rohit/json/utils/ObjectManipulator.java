package com.rohit.json.utils;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class ObjectManipulator {

	public void modifyNameOfAssociate(Associates associates, String nameToChange, String changeNameTo) {
		for(Associate associate: associates.getAssociates()) {
			if(nameToChange.equals(associate.getName())) {
				associate.setName(changeNameTo);
			}
		}
	}
	
	public void modifyIdOfAssociate(Associates associates, String idToChange, String changeIdTo) {
		for(Associate associate: associates.getAssociates()) {
			if(idToChange.equals(associate.getId())) {
				associate.setId(changeIdTo);
			}
		}
	}
	
}
