package co.edu.unbosque.sistemamestmejorado;

public class SystemModel {
	String name;
	String age;
	String year;
	
	SystemModel(String name, String age, String year){
		this.name = name;
		this.age = age;
		this.year = year;
	}
	
	public String getName() {
		return this.name;
	}
	public String getAge() {
		return this.age;
	}
	public String getYear() {
		return this.year;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	public void setAge(String value) {
		this.age = value;
	}
	public void setYear(String value) {
		this.year = value;
	}
}
