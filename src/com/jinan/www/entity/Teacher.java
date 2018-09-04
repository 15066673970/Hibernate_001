package com.jinan.www.entity;

import java.sql.Blob;

public class Teacher {
	private Integer id;
	private String name ;
	private String gender;
	private Integer age;
	private Blob photo;
	private Address address;
	
	
	
	public Teacher() {
	}

	public Teacher(String name, String gender, Integer age, Blob photo, Address address) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.photo = photo;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", photo=" + photo
				+ ", address=" + address + "]";
	}
	

	
	
}
