package com.estafet.openshift.boost.messages.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeatureMessageTest {

	@Test(expected = MissingFieldException.class)
	public void testBuilderMissingField() {
		FeatureMessage.builder()
				.setCommitId("dennis")
				.setDescription("this is a test")
				.setFeatureId("feature")
				.setRepo("repo")
				.setStatus(FeatureStatus.DONE)
				.setTitle("my title")
				.build();
	}

	@Test
	public void testBuilderSuccess() {
		FeatureMessage featureMessage = FeatureMessage.builder()
			.setCommitId("dennis")
			.setDescription("this is a test")
			.setFeatureId("feature")
			.setRepo("repo")
			.setStatus(FeatureStatus.DONE)
			.setTitle("my title")
			.setLastUpdated("now")
			.build();
		assertEquals("dennis", featureMessage.getCommitId());
		assertEquals("this is a test", featureMessage.getDescription());
		assertEquals("feature", featureMessage.getFeatureId());
		assertEquals("repo", featureMessage.getRepo());
		assertEquals(FeatureStatus.DONE, featureMessage.getStatus());
		assertEquals("my title", featureMessage.getTitle());
		assertEquals("now", featureMessage.getLastUpdated());
	}

}
