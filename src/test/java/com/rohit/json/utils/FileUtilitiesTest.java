package com.rohit.json.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rohit.json.dto.Associate;
import com.rohit.json.dto.Associates;

public class FileUtilitiesTest {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder(); 
	
	private final String TEST_FILE_NAME = "test.json";
	
	private String filePath;
	
	@Before
	public void setUp() throws Exception {
		filePath = temporaryFolder.getRoot().toString() + File.separatorChar + TEST_FILE_NAME;
	}

	@Test
	public void test_writeJsonToFile() throws JsonGenerationException, JsonMappingException, IOException {
		Associates associates = TestUtils.getAssociates();
		
		FileUtilities.writeJsonToFile(filePath, associates);
		
		String expectedString = "{\"associates\":[{\"name\":\"Name1\",\"id\":\"123\"},{\"name\":\"Name2\",\"id\":\"456\"}]}";
		
		String actualString;
		
		assertTrue(new File(filePath).exists());
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
			actualString = br.readLine();
		}
		
		assertEquals(expectedString, actualString);
	}
	
	@Test
	public void test_readJsonFromFile() throws JsonGenerationException, JsonMappingException, IOException {
		String json = "{\"associates\":[{\"name\":\"Name1\",\"id\":\"123\"},{\"name\":\"Name2\",\"id\":\"456\"}]}";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)))) {
			bw.write(json);
		}
		
		Associates expectedAssociates = TestUtils.getAssociates();
		
		Associates actualAssociates = FileUtilities.readJsonFromFile(filePath);
		
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
