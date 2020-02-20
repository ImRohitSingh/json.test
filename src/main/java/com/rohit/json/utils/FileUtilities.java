package com.rohit.json.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohit.json.dto.Associates;

public class FileUtilities {

	private FileUtilities() throws IllegalAccessException {
		throw new IllegalAccessException("Access method in static way");
	}
	
	public static void writeJsonToFile(String filePath, Associates associates) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File(filePath), associates);	
	}
	
	public static Associates readJsonFromFile(String filePath) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(new File(filePath), Associates.class);
	}
	
}
