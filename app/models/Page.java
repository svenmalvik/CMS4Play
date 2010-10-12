package models;


import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Page extends Model {

	public Page parentPage; 
	public String title;
	public String url;

	public Page(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	public Page(Page parentPage, String title, String url) {
		super();
		this.parentPage = parentPage;
		this.title = title;
		this.url = url;
	}
	
	public static Page getPageFromUrl(String url) {
		return Page.find("url", url).first();
	}
}
