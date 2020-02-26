package com.estafet.openshift.boost.messages.model;

public class FeatureMessageBuilder {

	private String commitId;
	private String repo;
	private String featureId;
	private String title;
	private String description;
	private FeatureStatus status;
	private String lastUpdated;

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
		nullCheck("commitId", "description", "lastUpdated", "status", "title", "repo", "featureId");
		FeatureMessage message = new FeatureMessage();
		message.setCommitId(commitId);
		message.setDescription(description);
		message.setLastUpdated(lastUpdated);
		message.setStatus(status);
		message.setTitle(title);
		message.setRepo(repo);
		message.setFeatureId(featureId);
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
