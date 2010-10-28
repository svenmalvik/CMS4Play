package models;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import play.Logger;
import play.db.jpa.Model;

@Entity
public class Page extends Model {

	public String title;
	public String url;

	public Page(String title, String url) {
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
	
	public void addPage(Page subPage) {
		addPage(subPage, false);
	}

	public void addPage(Page subPage, boolean isMenuLevel2) {
    	addSubPage(subPage);
    	if (isMenuLevel2) updateMenu(subPage);    	
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
}
