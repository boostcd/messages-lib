package com.estafet.openshift.boost.messages.model;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FeatureMessage {

	enum Status {
		NOT_STARTED, IN_PROGRESS, DONE
	}

	private String commitId;

	private String title;

	private String description;

	private Status status;
	
	private Date lastUpdated;

	public String getCommitId() {
		return commitId;
	}

	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public static FeatureMessageBuilder builder() {
		return new FeatureMessageBuilder();
	}
	
    public static FeatureMessage fromJSON(String message) {
        try {
            return new ObjectMapper().readValue(message, FeatureMessage.class);
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
