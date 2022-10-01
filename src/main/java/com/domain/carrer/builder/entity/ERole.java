package com.domain.carrer.builder.entity;

public enum ERole {
	ROLE_CANDIDATE("candidate"), ROLE_RECRUITER("recruiter"), ROLE_ADMIN("admin");

	private final String description;

	private ERole(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
