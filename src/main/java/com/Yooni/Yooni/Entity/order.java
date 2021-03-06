package com.Yooni.Yooni.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "Invitation")
public class order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="creator")
	private Long uid;
	
	@Column(name="creator_name")
	private String uname;
	
	@Column(name="title", nullable=false, length=50)
	private String title;
	
	@Column(name="ordpic", nullable=false, length=255)
	private String ordpic;
	
	@Lob
	@Column(name = "content" ,nullable=false,columnDefinition = "TEXT")
	private String content;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="req")
	private Integer req;
	
	@Column(name="curnum")
	private Integer cur = 0;
	
	@Column(name="state")
	private Integer state = 0;
	
	@CreatedDate
	@Column(name="creattime")
	private Date creattime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="destime",nullable=false)
	private Date destime;

	public order() {}

	public order(Long uid, String uname, String title, String ordpic, String content, Integer price, Integer req, Integer cur,
			Integer state, Date destime) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.title = title;
		this.ordpic = ordpic;
		this.content = content;
		this.price = price;
		this.req = req;
		this.cur = cur;
		this.state = state;
		this.destime = destime;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public String getOrdpic() {
		return ordpic;
	}

	public void setOrdpic(String ordpic) {
		this.ordpic = ordpic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getReq() {
		return req;
	}

	public void setReq(Integer req) {
		this.req = req;
	}

	public Integer getCur() {
		return cur;
	}

	public void setCur(Integer cur) {
		this.cur = cur;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getDestime() {
		return destime;
	}

	public void setDestime(Date destime) {
		this.destime = destime;
	}
	
	
	
	
	
}
