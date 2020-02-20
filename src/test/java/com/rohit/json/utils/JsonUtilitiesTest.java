package com.rohit.json.utils;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class JsonUtilitiesTest {

	@Test
	public void test_createAssociate() {
		Associate expectedAssociate = TestUtils.getAssociate();
		
		Associate actualAssociate = JsonUtilities.createAssociate("Name1", "123");
		
		assertEquals(expectedAssociate.getId(), actualAssociate.getId());
		assertEquals(expectedAssociate.getName(), actualAssociate.getName());
	}
	
	@Test
	public void test_createAssociates() {
		Associates expectedAssociates = TestUtils.getAssociates();
		
		List<Associate> listOfAssociates = new LinkedList<>();
        listOfAssociates.add(JsonUtilities.createAssociate("Name1","123"));
        listOfAssociates.add(JsonUtilities.createAssociate("Name2","456"));
		
		Associates actualAssociates = JsonUtilities.createListOfAssociates(listOfAssociates);
		
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
