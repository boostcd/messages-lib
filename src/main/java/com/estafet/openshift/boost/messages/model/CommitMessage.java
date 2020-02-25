package com.estafet.openshift.boost.messages.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommitMessage {

	private String commitId;
	
	private String message;

	public String getCommitId() {
		return commitId;
	}

	public void setCommitId(String commitId) {
		this.commitId = commitId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static CommitMessageBuilder builder() {
		return new CommitMessageBuilder();
	}
	
    public static CommitMessage fromJSON(String message) {
        try {
            return new ObjectMapper().readValue(message, CommitMessage.class);
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
