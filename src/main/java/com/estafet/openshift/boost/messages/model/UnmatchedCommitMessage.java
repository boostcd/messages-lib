package com.estafet.openshift.boost.messages.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UnmatchedCommitMessage {

	private String commitId;
	
	private String repo;

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
	
	public static UnmatchedCommitMessageBuilder builder() {
		return new UnmatchedCommitMessageBuilder();
	}
	
    public static UnmatchedCommitMessage fromJSON(String message) {
        try {
            return new ObjectMapper().readValue(message, UnmatchedCommitMessage.class);
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
