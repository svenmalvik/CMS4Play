package models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import play.data.binding.NoBinding;
import play.db.jpa.Model;

@Entity
public class Page extends Model {

	public String title;
	public String url;
	@Transient
	private List<Page> subPages;

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
    	subPages.add(subPage);
	}

	private void createSubmenuIfNotExistYet() {
		if (subPages == null) {
    		subPages = new ArrayList<Page>();
    		addSubpages2Menu();
    	}
	}

	private void addSubpages2Menu() {
		Menu.getInstance().getMenu().put(url, subPages);
	}
}
