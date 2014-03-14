package com.epam.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "NEWS")
public class News extends AbstractEntity {
	
	@Column
	private String content;
	@Column
	private String title;
	@Column
	private String brief;
	@Column
	private Date createdAt;

	public News() {
	}

	public News(String title, String brief, String content) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public News(String title, String brief, String content, Date date) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdAt = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
