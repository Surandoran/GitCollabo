package com.cosview.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String nickName;
	private String addr;
	private String email;
	private boolean gender;


	public MemberDTO(String id, String pw, String name, String nickName, String addr, String email, boolean gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickName = nickName;
		this.addr = addr;
		this.email = email;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"id='" + id + '\'' +
				", pw='" + pw + '\'' +
				", name='" + name + '\'' +
				", nickName='" + nickName + '\'' +
				", addr='" + addr + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
}
