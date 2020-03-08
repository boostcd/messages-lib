package com.estafet.openshift.boost.messages.environments;

import java.util.List;

import com.estafet.openshift.boost.messages.features.MissingFieldException;

public class EnvironmentBuilder {

	private String name;

	private String updatedDate;
	
	private boolean live;
	
	private List<EnvironmentApp> apps;

	public EnvironmentBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public EnvironmentBuilder setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
		return this;
	}

	public EnvironmentBuilder setLive(boolean live) {
		this.live = live;
		return this;
	}

	public EnvironmentBuilder setApps(List<EnvironmentApp> apps) {
		this.apps = apps;
		return this;
	}
	
	public Environment build() {
		nullCheck("name", "updatedDate", "live", "apps");
		Environment environment = new Environment();
		environment.setName(name);
		environment.setApps(apps);
		environment.setLive(live);
		environment.setUpdatedDate(updatedDate);
		return environment;
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
