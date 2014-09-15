package org.sgk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Message {

	@Column(name = "message_id")
	private Long id;

	@Column
	private String author;
	
	@Column
	private String title;
	
	@Column
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
