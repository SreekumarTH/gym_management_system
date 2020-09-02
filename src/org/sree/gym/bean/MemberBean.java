package org.sree.gym.bean;


public class MemberBean{
	private String username;
	private String password;
	private String name;
	private int age;
	
	
	
	public MemberBean(String username, String name, int age) {
		super();
		this.username = username;
		this.name = name;
		this.age = age;
	}

	public MemberBean(String username, String password, String name, int age) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
	}


	public MemberBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public MemberBean() {
		super();
		}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	


}
