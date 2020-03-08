package com.estafet.openshift.boost.messages.environments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

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

}