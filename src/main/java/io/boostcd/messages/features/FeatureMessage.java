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
	private String featureURL;

	public String getFeatureURL() {
		return featureURL;
	}

	public void setFeatureURL(String featureURL) {
		this.featureURL = featureURL;
	}

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
	
	public static class FeatureMessageBuilder {

		private String commitId;
		private String repo;
		private String featureId;
		private String title;
		private String description;
		private FeatureStatus status;
		private String lastUpdated;
		private String featureURL;

		private FeatureMessageBuilder() {}
		
		public FeatureMessageBuilder setFeatureURL(String featureURL) {
			this.featureURL = featureURL;
			return this;
		}

		public FeatureMessageBuilder setCommitId(String commitId) {
			this.commitId = commitId;
			return this;
		}

		public FeatureMessageBuilder setRepo(String repo) {
			this.repo = repo;
			return this;
		}

		public FeatureMessageBuilder setFeatureId(String featureId) {
			this.featureId = featureId;
			return this;
		}

		public FeatureMessageBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public FeatureMessageBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public FeatureMessageBuilder setStatus(FeatureStatus status) {
			this.status = status;
			return this;
		}

		public FeatureMessageBuilder setLastUpdated(String lastUpdated) {
			this.lastUpdated = lastUpdated;
			return this;
		}

		public FeatureMessage build() {
			nullCheck(
					"commitId",
					"lastUpdated",
					"status", 
					"title", 
					"repo", 
					"featureId", 
					"featureURL");
			FeatureMessage message = new FeatureMessage();
			message.setCommitId(commitId);
			message.setDescription(description);
			message.setLastUpdated(lastUpdated);
			message.setStatus(status);
			message.setTitle(title);
			message.setRepo(repo);
			message.setFeatureId(featureId);
			message.setFeatureURL(featureURL);
			return message;
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
