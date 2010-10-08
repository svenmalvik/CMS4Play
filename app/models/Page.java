package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Page extends Model {

	Page parentPage;
	String title;
	String url;

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
}
