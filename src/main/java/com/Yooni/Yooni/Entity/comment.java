package com.Yooni.Yooni.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


@Entity
public class comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinTable(name = "CommentUser",joinColumns = { @JoinColumn(name = "cid")},inverseJoinColumns ={@JoinColumn(name = "uid") })
	private User user;
	
	private Long ordId;

	private Long yid;
	
	private String content;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP) 
	private Date creattime;

	public comment() {};
	
	public comment(User user, Long ordId, Long yid, String content) {
		super();
		this.user = user;
		this.ordId = ordId;
		this.yid = yid;
		this.content = content;
	}

	public Long getYid() {
		return yid;
	}

	public void setYid(Long yid) {
		this.yid = yid;
	}

	public comment(User user, Long ord, String content) {
		this.user = user;
		this.ordId = ord;
		this.content = content;
	}

	@Override
	public String toString() {
		return "comment [id=" + id + ", user=" + user + ", ord=" + ordId + ", content=" + content + ", creattime="
				+ creattime + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getOrd() {
		return ordId;
	}

	public void setOrd(Long ord) {
		this.ordId = ord;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	
	
	
}
