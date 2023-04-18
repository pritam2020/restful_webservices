package com.pritam.demorest;


import jakarta.xml.bind.annotation.*;

@XmlRootElement
public class Alien {
	
	private int age;
	private String name ;
	private String nickname;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Alien [age=" + age + ", name=" + name + ", nickname=" + nickname + "]";
	}
	

}
