package com.estafet.openshift.boost.messages.environments;

import com.estafet.openshift.boost.messages.features.MissingFieldException;

public class EnvironmentAppBuilder {

	private String name;
	
	private String version;

	private String deployedDate;

	public EnvironmentAppBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public EnvironmentAppBuilder setVersion(String version) {
		this.version = version;
		return this;
	}

	public EnvironmentAppBuilder setDeployedDate(String deployedDate) {
		this.deployedDate = deployedDate;
		return this;
	}
	
	public EnvironmentApp build() {
		nullCheck("name", "version");
		EnvironmentApp app = new EnvironmentApp();
		app.setDeployedDate(deployedDate);
		app.setName(name);
		app.setVersion(version);
		return app;
	}
	
	private void nullCheck(String...fields) {
		for (String field : fields) {
			nullCheck(field);
		}
	}
	
	private void nullCheck(String field) {
		try {
			if (this.getClass().getDeclaredField(field).get(this) == null) {
				throw new MissingFieldException(field + " cannot be null");
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
}
