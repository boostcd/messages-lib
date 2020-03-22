package com.estafet.openshift.boost.messages.environments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.boost.messages.features.MissingFieldException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Environment {

	private String name;
	private String displayName;
	private String updatedDate;
	private Boolean live;
	private Boolean tested;

	private List<EnvironmentApp> apps = new ArrayList<EnvironmentApp>();

	public void addApp(EnvironmentApp app) {
		apps.add(app);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getTested() {
		return tested;
	}

	public void setTested(Boolean tested) {
		this.tested = tested;
	}

	public Boolean getLive() {
		return live;
	}

	public void setLive(Boolean live) {
		this.live = live;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public List<EnvironmentApp> getApps() {
		return apps;
	}

	public void setApps(List<EnvironmentApp> apps) {
		this.apps = apps;
	}
	
	public EnvironmentApp getEnvironmentApp(String name) {
		for (EnvironmentApp app : apps) {
			if (app.getName().equals(name)) {
				return app;
			}
		}
		return null;
	}

	public static Environment fromJSON(String message) {
		try {
			return new ObjectMapper().readValue(message, Environment.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String toJSON() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static EnvironmentBuilder builder() {
		return new EnvironmentBuilder();
	}

	public static class EnvironmentBuilder {

		private String name;
		private String displayName;
		private String updatedDate;
		private Boolean live;
		private Boolean tested;

		private EnvironmentBuilder() {
		}

		public EnvironmentBuilder setDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public EnvironmentBuilder setTested(Boolean tested) {
			this.tested = tested;
			return this;
		}

		public EnvironmentBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EnvironmentBuilder setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}

		public EnvironmentBuilder setLive(Boolean live) {
			this.live = live;
			return this;
		}

		public Environment build() {
			nullCheck("name", "updatedDate", "live", "displayName");
			Environment environment = new Environment();
			environment.setName(name);
			environment.setLive(live);
			environment.setUpdatedDate(updatedDate);
			environment.setTested(tested);
			environment.setDisplayName(displayName);
			return environment;
		}

		private void nullCheck(String... fields) {
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

}