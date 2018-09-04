package com.jinan.www.entity;

public class Address {

		private String postnumber;
		private String phone;
		private String address;
		
		public Address() {
		}
		public Address(String postnumber, String phone, String address) {
			super();
			this.postnumber = postnumber;
			this.phone = phone;
			this.address = address;
		}
		public String getPostnumber() {
			return postnumber;
		}
		public void setPostnumber(String postnumber) {
			this.postnumber = postnumber;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Address [postnumber=" + postnumber + ", phone=" + phone + ", address=" + address + "]";
		}
		 
}
