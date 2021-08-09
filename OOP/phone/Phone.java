package com.codingdojo.javaoop.phone;

public abstract class Phone {
	private String versionNumber;
	private int batteryPercentage;
	private String carrier;
	private String ringTone;
	
	public Phone(String versionNumberInput, int batteryPercentageInput, String carrierInput, String ringToneInput) {
		this.versionNumber = versionNumberInput;
		this.batteryPercentage = batteryPercentageInput;
		this.carrier = carrierInput;
		this.ringTone = ringToneInput;
	}
	
	// getters and setters
	public String getVersionNumber() {
		return versionNumber;
	}
	
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getRingTone() {
		return ringTone;
	}

	public void setRingTone(String ringTone) {
		this.ringTone = ringTone;
	}

	// abstract method implemented in subclass
	public abstract void displayInfo();
	
}
