package kr.green.spring.vo;

import java.sql.Date;

public class AccountVo {
	private String id;//DB의 컬럼명과 일치해야 한다. 카멜표기법에는 어긋나지만 편하고 쉽다
	private String pw;
	private String email;
	private String gender;
	private String authority;
	private String registered_date;
	//private만 적고 우클릭하고 소스-제네레이터 게터세터 하면 알아서 만들어 준다. 밑의 To스트링도 마찬가지
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(String registered_date) {
		this.registered_date = registered_date;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", authority="
				+ authority + ", registered_date=" + registered_date + "]";
	}
	
}
