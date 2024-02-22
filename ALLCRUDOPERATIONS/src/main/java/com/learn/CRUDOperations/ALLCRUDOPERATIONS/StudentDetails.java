package com.learn.CRUDOperations.ALLCRUDOPERATIONS;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	private int s_id;
	private String s_name;
	private int s_age;
	private float s_marks;
	private String s_email;
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDetails(int s_id, String s_name, int s_age, float s_marks, String s_email) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.s_marks = s_marks;
		this.s_email = s_email;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public float getS_marks() {
		return s_marks;
	}
	public void setS_marks(float s_marks) {
		this.s_marks = s_marks;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	@Override
	public String toString() {
		return "StudentDetails [s_id=" + s_id + ", s_name=" + s_name + ", s_age=" + s_age + ", s_marks=" + s_marks
				+ ", s_email=" + s_email + "]";
	}
}
