package com.estafet.openshift.boost.messages.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.estafet.openshift.boost.messages.features.CommitMessage;
import com.estafet.openshift.boost.messages.features.MissingFieldException;

public class CommitMessageTest {

	@Test(expected = MissingFieldException.class)
	public void testBuilderMissingField() {
		CommitMessage.builder().setCommitId("dennis").setMessage("this is a test").build();
	}
	
	@Test
	public void testBuilderSuccess() {
		CommitMessage commitMessage = CommitMessage.builder().setRepo("my repo").setCommitId("dennis").setMessage("this is a test").build();
		assertEquals("my repo", commitMessage.getRepo());
		assertEquals("dennis", commitMessage.getCommitId());
		assertEquals("this is a test", commitMessage.getMessage());
	}

}
