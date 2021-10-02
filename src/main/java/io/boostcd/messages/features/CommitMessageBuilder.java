package com.estafet.openshift.boost.messages.features;

public class CommitMessageBuilder {

	private String commitId;
	private String repo;
	private String message;

	public CommitMessageBuilder setRepo(String repo) {
		this.repo = repo;
		return this;
	}

	public CommitMessageBuilder setCommitId(String commitId) {
		this.commitId = commitId;
		return this;
	}

	public CommitMessageBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public CommitMessage build() {
		nullCheck("commitId", "repo", "message");
		CommitMessage commitMessage = new CommitMessage();
		commitMessage.setCommitId(commitId);
		commitMessage.setRepo(repo);
		commitMessage.setMessage(message);
		return commitMessage;
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
