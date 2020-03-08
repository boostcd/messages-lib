package com.estafet.openshift.boost.messages.features;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FeatureMessage {

	private String commitId;
	private String repo;
	private String featureId;
	private String title;
	private String description;
	private FeatureStatus status;
	private String lastUpdated;

	public String getCommitId() {
		return commitId;
	}

	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
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

	public FeatureStatus getStatus() {
		return status;
	}

	public void setStatus(FeatureStatus status) {
		this.status = status;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
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
