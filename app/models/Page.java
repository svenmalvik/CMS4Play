package models;


import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Page extends Model {

	public String title;
	public String url;

	public Page(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	public static Page getPageFromUrl(String url) {
		return Page.find("url", url).first();
	}
	
	public Page save() {
		Page page = Page.find("url", url).first();
		if (page == null) {
			page = super.save();
		}
		return page;
	}
}
