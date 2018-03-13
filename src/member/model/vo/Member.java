package member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable{
	
	//반드시 직렬화.
	// 캡슐화 무조건 프라이빗
	// 기본생성자와 매걔변수가 있는생성자 작성.
	// 모든 필드에 관한 겟터 셋터가 필요함.
	private final static long serialVersionUID=7l;
	private String userid;
	private String userPwd;
	private String userName;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String hobby;
	private String etc;
	private Date enrollDate;
	private Date lastModified;
	public Member(String userid, String userPwd, String userName, String gender, int age, String phone, String email,
			String hobby, String etc) {
		super();
		this.userid = userid;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
	}

	public Member(String userid, String userPwd, String userName, String gender, int age, String phone, String email,
			String hobby, String etc, Date enrollDate, Date lastModified) {
		super();
		this.userid = userid;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.hobby = hobby;
		this.etc = etc;
		this.enrollDate = enrollDate;
		this.lastModified = lastModified;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.userid+")("+this.userPwd+")("+this.userName+")("+this.gender+")("+this.age+")("+this.email+")("+this.hobby+")("+this.phone+")("+this.etc+")("+this.enrollDate+")("+this.lastModified+")";
	}

	
}
