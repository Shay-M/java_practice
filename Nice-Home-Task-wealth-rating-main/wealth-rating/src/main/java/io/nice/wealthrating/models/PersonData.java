package io.nice.wealthrating.models;

import com.sun.istack.NotNull;

public class PersonData {
	
	private long id;
	private PersonalInfo personalInfo;
	private FinancialInfo financialInfo;

	
	public PersonData(@NotNull long id, @NotNull PersonalInfo personalInfo, @NotNull FinancialInfo financialInfo) {
		super();
		this.id = id;
		this.personalInfo = personalInfo;
		this.financialInfo = financialInfo;
	}
	
	public String getCity() {
		return personalInfo.getCity();
	}
	public String getFirstName() {
		return personalInfo.getFirstName();
	}
	public String getLastName() {
		return personalInfo.getLastName();
	}
	public long getCash() {
		return financialInfo.getCash();
	}
	public int getNumberOfAssets() {
		return financialInfo.getNumberOfAssets();
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public FinancialInfo getFinancialInfo() {
		return financialInfo;
	}
	public void setFinancialInfo(FinancialInfo financialInfo) {
		this.financialInfo = financialInfo;
	}
	
}
