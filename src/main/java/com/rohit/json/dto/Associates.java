package com.rohit.json.dto;

import java.io.Serializable;
import java.util.List;

public class Associates implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Associate> listOfAssociates;

	public List<Associate> getAssociates() {
		return listOfAssociates;
	}

	public void setAssociates(List<Associate> associates) {
		this.listOfAssociates = associates;
	}
	
	
}
