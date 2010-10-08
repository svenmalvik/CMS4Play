package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Page extends Model {

	long parentPageId;
	String title;
	String url;

	public Page(long parentPageId, String title, String url) {
		super();
		this.parentPageId = parentPageId;
		this.title = title;
		this.url = url;
	}
}
