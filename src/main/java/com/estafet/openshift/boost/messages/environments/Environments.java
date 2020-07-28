package com.estafet.openshift.boost.messages.environments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Environments {

	private String productId;
	private List<Environment> environments = new ArrayList<Environment>();

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public List<Environment> getEnvironments() {
		return environments;
	}

	public void addEnvironment(Environment environment) {
		environments.add(environment);
	}
	
	public static Environments fromJSON(String message) {
		try {
			return new ObjectMapper().readValue(message, Environments.class);
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
	
	public static EnvironmentsBuilder builder() {
		return new EnvironmentsBuilder();
	}
	
	public static class EnvironmentsBuilder {
		
		private String productId;
		
		public EnvironmentsBuilder setProductId(String productId) {
			this.productId = productId;
			return this;
		}

		public Environments build() {
			Environments environments = new Environments();
			environments.setProductId(productId);
			return environments;
		}
		
	}

}
