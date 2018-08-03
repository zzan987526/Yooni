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
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinTable(name = "CommentOrder",joinColumns = { @JoinColumn(name = "cid")},inverseJoinColumns ={@JoinColumn(name = "oid") })
	private order ord;

	private String content;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP) 
	private Date creattime;

	public comment(User user, order ord, String content) {
		this.user = user;
		this.ord = ord;
		this.content = content;
	}

	@Override
	public String toString() {
		return "comment [id=" + id + ", user=" + user + ", ord=" + ord + ", content=" + content + ", creattime="
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

	public order getOrd() {
		return ord;
	}

	public void setOrd(order ord) {
		this.ord = ord;
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
