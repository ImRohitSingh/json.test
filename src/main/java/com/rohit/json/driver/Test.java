package com.rohit.json.driver;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;
import com.rohit.json.utils.FileUtilities;
import com.rohit.json.utils.JsonUtilities;
import com.rohit.json.utils.ObjectManipulator;

public class Test {

	private static final Logger LOGGER = Logger.getLogger(Test.class);
	
	private static final String JSON_FILE_PATH = "associates.json";

	private static final String NAME_TO_CHANGE = "Daniel Hardman";

	private static final String CHANGE_NAME_TO = "Jessica Pearson";

	private static final String ID_TO_CHANGE = "ABCDEFG";

	private static final String CHANGE_ID_TO = "JP0000";

	public static void main(String[] args) {
		List<Associate> listOfAssociates = new LinkedList<>();
		listOfAssociates.add(JsonUtilities.createAssociate(NAME_TO_CHANGE, ID_TO_CHANGE));
		listOfAssociates.add(JsonUtilities.createAssociate("Harvey Spector", "HS9999"));

		Associates associates = JsonUtilities.createListOfAssociates(listOfAssociates);

		try {
			FileUtilities.writeJsonToFile(JSON_FILE_PATH, associates);
			LOGGER.info("Written to " + JSON_FILE_PATH + " successfully");
			
			Associates newAssociatesObject = FileUtilities.readJsonFromFile(JSON_FILE_PATH);

			ObjectManipulator objectManipulator = new ObjectManipulator();
			objectManipulator.modifyNameOfAssociate(newAssociatesObject, NAME_TO_CHANGE, CHANGE_NAME_TO);
			objectManipulator.modifyIdOfAssociate(newAssociatesObject, ID_TO_CHANGE, CHANGE_ID_TO);

			FileUtilities.writeJsonToFile(JSON_FILE_PATH, newAssociatesObject);
			LOGGER.info("Modified " + NAME_TO_CHANGE + " to " + CHANGE_NAME_TO +" and " + ID_TO_CHANGE + " to " + CHANGE_ID_TO + " in " + JSON_FILE_PATH + " successfully");

		} catch (IOException e) {
			LOGGER.error("Failed with: " + e);
		}
	}

}
