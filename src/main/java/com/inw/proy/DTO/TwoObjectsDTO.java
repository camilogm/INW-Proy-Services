package com.inw.proy.DTO;

public class TwoObjectsDTO {

	private Object objectOne;
	private Object objectTwo;
	
	public TwoObjectsDTO() {
		
		this.objectOne = null;
		this.objectTwo = null;
	}
	
	public TwoObjectsDTO(Object objectOne, Object objectTwo) {
		this.objectOne = objectOne;
		this.objectTwo = objectTwo;
	}

	public Object getObjectOne() {
		return objectOne;
	}

	public void setObjectOne(Object objectOne) {
		this.objectOne = objectOne;
	}

	public Object getObjectTwo() {
		return objectTwo;
	}

	public void setObjectTwo(Object objectTwo) {
		this.objectTwo = objectTwo;
	}
	
	
	
	
}
