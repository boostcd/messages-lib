package com.estafet.openshift.boost.messages.model;

import java.text.ParseException;

import com.estafet.openshift.boost.commons.lib.date.DateUtils;
import com.estafet.openshift.boost.messages.model.FeatureMessage.Status;

public class FeatureMessageBuilder {

	private String commitId;

	private String title;

	private String description;

	private Status status;
	
	private String lastUpdated;

	public FeatureMessageBuilder setCommitId(String commitId) {
		this.commitId = commitId;
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

	public FeatureMessageBuilder setStatus(Status status) {
		this.status = status;
		return this;
	}

	public FeatureMessageBuilder setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}
	
	public FeatureMessage build() {
		FeatureMessage message = new FeatureMessage();
		message.setCommitId(commitId);
		message.setDescription(description);
		try {
			message.setLastUpdated(DateUtils.dateFormat.parse(lastUpdated));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		message.setStatus(status);
		message.setTitle(title);
		return message;
	}
	
}
