package com.codingdojo.javaoop.phone;

public class Galaxy extends Phone implements Ringable {
	public Galaxy(String versionNumberInput, int batteryPercentageInput, String carrierInput, String ringToneInput) {
		super(versionNumberInput, batteryPercentageInput, carrierInput, ringToneInput);
	}
	
	@Override
	public String ring() {
		return this.getRingTone();
	}
	@Override
	public String unlock() { 
		return "unlocking via finger print";
	}
	@Override
	public void displayInfo() {
		System.out.println("Galaxy" + this.getVersionNumber() + "from" + this.getCarrier());
	}
}
