package main;

public class Address {
	private String doorNo;
	private String state;
	private String district;
	private String city;
	private String village;
	private long pincode;

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String displayAddress() {

		return "Door Number :" + doorNo + "\nVillage :" + village + "\nCity :" + city + "\nDistrict :" + district
				+ "\nState :" + state + "\nPincode :" + pincode;
	}

}
