package com.estafet.openshift.boost.messages.model;

public class CommitMessageBuilder {

	private String commitId;
	
	private String message;

	public CommitMessageBuilder setCommitId(String commitId) {
		this.commitId = commitId;
		return this;
	}

	public CommitMessageBuilder setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public CommitMessage build() {
		CommitMessage commitMessage = new CommitMessage();
		commitMessage.setCommitId(commitId);
		commitMessage.setMessage(message);
		return commitMessage;
	}
	
}
