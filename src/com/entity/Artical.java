package com.entity;

public class Artical {
	private String artical_id;// varchar(36) primary key comment "ÎÄÕÂµÄID",
	private String artical_title;// varchar(300) not null,
	private String artical_date;// varchar(26) not null,
	private String artical_content;// longtext,
	private String nav_id;// varchar(36) not null
	public String getArtical_id() {
		return artical_id;
	}
	public void setArtical_id(String artical_id) {
		this.artical_id = artical_id;
	}
	public String getArtical_title() {
		return artical_title;
	}
	public void setArtical_title(String artical_title) {
		this.artical_title = artical_title;
	}
	public String getArtical_date() {
		return artical_date;
	}
	public void setArtical_date(String artical_date) {
		this.artical_date = artical_date;
	}
	public String getArtical_content() {
		return artical_content;
	}
	public void setArtical_content(String artical_content) {
		this.artical_content = artical_content;
	}
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
}
