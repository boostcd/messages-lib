package com.estafet.openshift.boost.messages.features;

public enum FeatureStatus {
	NOT_STARTED("Not Started"),
	IN_PROGRESS("In Progress"),
	DONE("Done"),
	BLOCKED("Blocked");

	private String value;

	FeatureStatus(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}