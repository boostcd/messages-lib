package com.estafet.openshift.boost.messages.environments;

import java.util.ArrayList;
import java.util.List;

public class Environment {

	private String name;

	private String updatedDate;
	
	private boolean live;
	
	private List<EnvironmentApp> apps = new ArrayList<EnvironmentApp>();

	public void addApp(EnvironmentApp app) {
		apps.add(app);
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
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

}