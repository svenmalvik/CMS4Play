package models;

//@author Sven Malvik

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Content2PageMapping extends Model {
	
	@OneToOne
	public Content content;
	@OneToOne
	public Page page;
	
	public Content2PageMapping(Content content, Page page) {
		this.content = content;
		this.page = page;
	}
	
	public static Content2PageMapping getFirstC2PFromPage(Page page) {
		return Content2PageMapping.find("page = ?", page).first();
	}
	
	public String toString() {
		return "Page:" + page.title + "; Content:" + content.content;
	}
}