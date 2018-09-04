package com.jinan.www.entity;
//学生类

import java.sql.Blob;
import java.util.Date;

public class Students {
	//共有的类
	//提供参数列表为空的构造方法
	//属性私有化
	//提供属性的gettersetter方法
	
		private int sid;//学号
		private String sname;//姓名
		private String gender;//性别
		private Date birthday;//出生日期
		private String address;// 地址
		private Blob picture;//头像
		public Students() {
			super();
		}
		public Students(int sid, String sname, String gender, Date birthday,String address) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.gender = gender;
			this.birthday = birthday;
			this.address = address;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		public Blob getPicture() {
			return picture;
		}
		public void setPicture(Blob picture) {
			this.picture = picture;
		}
		@Override
		public String toString() {
			return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
					+ ", address=" + address + ", picture=" + picture + "]";
		}
	
		 
		
		
		
		
}
