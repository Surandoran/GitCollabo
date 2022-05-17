package com.cosview.dto;

public class MemberDTO extends DTO {
	private String nickName;
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String email;
	private String gender;

	public MemberDTO(String nickName, String id, String pw, String name, String addr, String email, String gender) {
		this.nickName = nickName;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.email = email;
		this.gender = gender;
	}

	public MemberDTO(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "MemberDTO{" +
				"nickName='" + nickName + '\'' +
				", id='" + id + '\'' +
				", pw='" + pw + '\'' +
				", name='" + name + '\'' +
				", addr='" + addr + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
}
