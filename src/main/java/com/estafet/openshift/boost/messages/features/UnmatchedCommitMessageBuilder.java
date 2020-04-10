package com.estafet.openshift.boost.messages.features;

public class UnmatchedCommitMessageBuilder {

	private String commitId;
	private String repo;

	public UnmatchedCommitMessageBuilder setRepo(String repo) {
		this.repo = repo;
		return this;
	}

	public UnmatchedCommitMessageBuilder setCommitId(String commitId) {
		this.commitId = commitId;
		return this;
	}

	public UnmatchedCommitMessage build() {
		nullCheck("commitId", "repo");
		UnmatchedCommitMessage unmatchedCommitMessage = new UnmatchedCommitMessage();
		unmatchedCommitMessage.setCommitId(commitId);
		unmatchedCommitMessage.setRepo(repo);
		return unmatchedCommitMessage;
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
