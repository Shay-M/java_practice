package io.nice.wealthrating.models;

public class FinancialInfo {
	
	private long cash;
	private int numberOfAssets;
	
	
	
	public FinancialInfo(long cash, int numberOfAssets) {
		super();
		this.cash = cash;
		this.numberOfAssets = numberOfAssets;
	}
	
	public long getCash() {
		return cash;
	}
	public void setCash(long cash) {
		this.cash = cash;
	}
	public int getNumberOfAssets() {
		return numberOfAssets;
	}
	public void setNumberOfAssets(int numberOfAssets) {
		this.numberOfAssets = numberOfAssets;
	}
}
