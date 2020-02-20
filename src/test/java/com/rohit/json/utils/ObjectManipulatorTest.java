package com.rohit.json.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class ObjectManipulatorTest {

	private ObjectManipulator objectManipulator;
	
	private final String NAME_TO_CHANGE = "Name2";
	
	private final String CHANGE_NAME_TO = "Name3";
	
	private final String ID_TO_CHANGE = "456";
	
	private final String CHANGE_ID_TO = "789";
	
	@Before
	public void setUp() {
		objectManipulator = new ObjectManipulator();
	}
	
	@Test
	public void test_modifyAssociates() {
		Associates expectedAssociates = TestUtils.getModifiedAssociates();
		
		Associates actualAssociates = TestUtils.getAssociates();
		objectManipulator.modifyNameOfAssociate(actualAssociates, NAME_TO_CHANGE, CHANGE_NAME_TO);
		objectManipulator.modifyIdOfAssociate(actualAssociates, ID_TO_CHANGE, CHANGE_ID_TO);
		
		Iterator<Associate> itrExpectedAssociates = expectedAssociates.getAssociates().iterator();
		Iterator<Associate> itrActualAssociates = actualAssociates.getAssociates().iterator();
		
		while(itrActualAssociates.hasNext() && itrExpectedAssociates.hasNext()) {
			Associate expectedAssoicate = itrExpectedAssociates.next();
			Associate actualAssociate = itrActualAssociates.next();
			
			assertEquals(expectedAssoicate.getId(), actualAssociate.getId());
			assertEquals(expectedAssoicate.getName(), actualAssociate.getName());
		}
	}

}
