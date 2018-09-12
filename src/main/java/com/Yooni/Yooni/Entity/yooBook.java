package com.Yooni.Yooni.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class yooBook {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long uid;
	
	private String title;
	
	private String toppic;
	
	@Lob
	@Column(name = "content" ,nullable=false,columnDefinition = "TEXT")
	private String content;
	
	@CreatedDate
	@Column(name="creattime")
	private Date creattime;

	public yooBook(Long uid, String title, String toppic, String content) {
		super();
		this.uid = uid;
		this.title = title;
		this.toppic = toppic;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getToppic() {
		return toppic;
	}

	public void setToppic(String toppic) {
		this.toppic = toppic;
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
