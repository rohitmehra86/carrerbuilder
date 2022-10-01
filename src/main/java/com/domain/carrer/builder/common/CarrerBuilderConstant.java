package com.domain.carrer.builder.common;

public class CarrerBuilderConstant {
	public enum Gender {
		MALE("male"), FEMALE("female"), TRANSGEN("transgen");

		private final String description;

		private Gender(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}
}
