package com.example.demo.personnes.process;

import java.io.Serializable;

public class Personne  {

	private String prenom;
	private int age;
	
	public Personne() {
		super();
	}
	
	public Personne(String prenom, int age) {
		super();
		this.prenom = prenom;
		this.age = age;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
