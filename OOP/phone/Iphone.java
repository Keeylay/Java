package com.codingdojo.javaoop.phone;

public class Iphone extends Phone implements Ringable {
	public Iphone(String versionNumberInput, int batteryPercentageInput, String carrierInput, String ringToneInput) {
		super(versionNumberInput, batteryPercentageInput, carrierInput, ringToneInput);
	}
	
	// ring method from Ringable interface 
	@Override
	public String ring() {
		return this.getRingTone();
	}
	
	// unlock method from  interface
	@Override
	public String unlock() {
		return "Unlockining via facial recongnition";
	}
	@Override
	public void displayInfo() {
		System.out.println("IPhone " + this.getVersionNumber() + " from " + this.getCarrier());
	}
}
