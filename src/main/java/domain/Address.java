package domain;

public class Address {

	private int id;
	private String city;
	private String street;
	private int house_number;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHouseNumber() {
		return house_number;
	}
	public void setHouseNumber(int house_number) {
		this.house_number = house_number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
