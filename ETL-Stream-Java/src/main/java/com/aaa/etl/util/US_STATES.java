package com.aaa.etl.util;

public enum US_STATES {
	
	AL("AL", "ALABAMA"),	
	AK("AK", "ALASKA"),
	AZ("AZ", "ARIZONA"),	
	AR("AR", "ARKANSAS"),
	CA("CA", "CALIFORNIA");
//	CO("CO", "COLORADO"),
//	CT("CT", "CONNECTICUT"),	
//	DE("DE", "DELAWARE"),
//	DC("DC", "DISTRICT OF COLUMBIA"),
//	FL("FL", "FLORIDA"),	
//	GA("GA", "GEORGIA"),	
//	GU("GU", "GUAM"),
//	HI("HI", "HAWAII"),
//	ID("ID", "IDAHO"),
//	IL("IL", "ILLINOIS"),
//	IN("IN", "INDIANA"),	
//	IA("IA", "IOWA"),
//	KS("KS", "KANSAS"),
//	KY("KY", "KENTUCKY"),
//	LA("LA", "LOUISIANA"),
//	ME("ME", "MAINE"),
//	MD("MD", "MARYLAND"),
//	MA("MA", "MASSACHUSETTS"),
//	MI("MI", "MICHIGAN"),
//	MN("MN", "MINNESOTA"),
//	MS("MS", "MISSISSIPPI"),	
//	MO("MO", "MISSOURI"),
//	MT("MT", "MONTANA"),	
//	NE("NE", "NEBRASKA"),
//	NV("NV", "NEVADA"),
//	NH("NH", "NEW HAMPSHIRE"),
//	NJ("NJ", "NEW JERSEY"),
//	NM("NM", "NEW MEXICO"),
//	NY("NY", "NEW YORK"),
//	NC("NC", "NORTH CAROLINA"),
//	ND("ND", "NORTH DAKOTA"),
//	OH("OH", "OHIO"),
//	OK("OK", "OKLAHOMA"),
//	OR("OR", "OREGON"),
//	PA("PA", "PENNSYLVANIA"),
//	PR("PR", "PUERTO RICO"),	
//	RI("RI", "RHODE ISLAND"),
//	SC("SC", "SOUTH CAROLINA"),
//	SD("SD", "SOUTH DAKOTA"),
//	TN("TN", "TENNESSEE"),
//	TX("TX", "TEXAS"),
//	UT("UT", "UTAH"),
//	VT("VT", "VERMONT"),	
//	VA("VA", "VIRGINIA"),
//	VI("VI", "VIRGIN ISLANDS"),
//	WA("WA", "WASHINGTON"),
//	WV("WV", "WEST VIRGINIA"),
//	WI("WI", "WISCONSIN"),
//	WY("WY", "WYOMING");
	
	private String keyAbbreviation;
	private String valueFullname;
	
	US_STATES(String keyAbbreviation, String valueFullname) {
		this.keyAbbreviation = keyAbbreviation;
		this.valueFullname = valueFullname;
	}
	
	public String getKeyAbbreviation() {
		return keyAbbreviation;
	}
	
	public String getValueFullname() {
		return valueFullname;
	}
	
	public static US_STATES parse(String input) {
		if (input == null) {
			return null;
		}
		
		input = input.trim();
		for (US_STATES state: values()) {
			if (state.keyAbbreviation.equalsIgnoreCase(input) || state.valueFullname.equalsIgnoreCase(input)) {
				return state;
			}
		}
		
		return null;
	}
}
