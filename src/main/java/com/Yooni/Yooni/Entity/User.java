package com.Yooni.Yooni.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="username", nullable=false, length=30)
	private String username;
	
	@Column(name="password", nullable=false, length=30)
	private String password;
	
	@Column(name="nickname", nullable=true, length=50)
	private String nickname;
	
	@Column(name="email", nullable=true, length=30)
	private String email;
	
	@Column(name="credit", nullable=false)
	private int credit;
	
	@Column(name="avatar",nullable=true,length=255)
	private String avatar;
	
	@Column(name="phone", nullable=true,length=11)
	private String phone;
	
	private int privilege;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP) 
	private Date creattime;
	
	public User() {}
	
	public User(String username, String password, String nickname, String email, int credit, String avatar, String phone,
			int privilege) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.credit = credit;
		this.avatar = avatar;
		this.phone = phone;
		this.privilege = privilege;
	}
	
	@Override
    public String toString() {
		return "User [id=" + id + 
				", username=" + username + 
				", password=" + password + 
				", email=" + email + 
				", credit=" + credit + 
				",phone=" + phone + 
				",creattime=" + creattime + 
				",privilege=" + privilege + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	
	
}
