package models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Index;

import play.db.jpa.Model;

@Entity
public class Page extends Model {

	public String title;
	@Index(name="urlx")
	public String url;
	public String parentPageUrl;
	public int positionInMenu;

	public Page(String title, String url, String parentPageUrl, int position) {
		this.title = title;
		this.url = url;
		this.parentPageUrl = parentPageUrl;
		this.positionInMenu = position;
		save();
	}
	
	public static Page getPageFromUrl(String url) {
		return Page.find("url", url).first();
	}
	
	public Page save() {
		Page page = Page.find("url", url).first();
		if (page == null) {
			page = super.save();
		} else {
			page.update(this);
		}
		return page;
	}
	
	private void update(Page newPageAttributes) {
		title = newPageAttributes.title;
		parentPageUrl = newPageAttributes.parentPageUrl;
		positionInMenu = newPageAttributes.positionInMenu;
		super.save();
	}

	public void addPage(Page subPage) {
		addSubPage(subPage);
		if (!StringUtils.equals(subPage.parentPageUrl, "index")) {
			updateMenu(subPage);
		}
	}

	private void updateMenu(Page subPage) {
		List<Page> pathSubpage = new ArrayList<Page>();
    	pathSubpage.add(this);
    	Menu.getInstance().getPagePathes().put(subPage.url, pathSubpage); 
	}

	private void addSubPage(Page subPage) {
		createSubmenuIfNotExistYet();
		Menu.getInstance().getSubmenuForUrl(url).add(subPage);
	}

	private void createSubmenuIfNotExistYet() {
		if (Menu.getInstance().getSubmenuForUrl(url) == null) {
			Menu.getInstance().addSubpages(url, new ArrayList<Page>());
    	}
	}
	
	public String toString() {
		return "Title:" + title + " Url:" + url;
	}

	public static List<Page> getAllPossibleParentPages() {
		return Page.find("parentPageUrl = ? order by title", "index").fetch();
	}
}
