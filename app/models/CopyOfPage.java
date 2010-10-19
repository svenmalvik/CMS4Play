package models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import play.data.binding.NoBinding;
import play.db.jpa.Model;

@Entity
public class CopyOfPage extends Model {

	public String title;
	public String url;
	@Transient
	private List<CopyOfPage> subPages;

	public CopyOfPage(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}
	
	public static CopyOfPage getPageFromUrl(String url) {
		return CopyOfPage.find("url", url).first();
	}
	
	public CopyOfPage save() {
		CopyOfPage page = CopyOfPage.find("url", url).first();
		if (page == null) {
			page = super.save();
		}
		return page;
	}
	
	public void addPage(CopyOfPage subPage) {
		addPage(subPage, false);
	}

	public void addPage(CopyOfPage subPage, boolean isMenuLevel2) {
    	addSubPage(subPage);
    	if (isMenuLevel2) updateMenu(subPage);    	
	}

	private void updateMenu(CopyOfPage subPage) {
		List<CopyOfPage> pathSubpage = new ArrayList<CopyOfPage>();
    	pathSubpage.add(this);
    	Menu.getInstance().getPagePathes().put(subPage.url, pathSubpage); 
	}

	private void addSubPage(CopyOfPage subPage) {
		createSubmenuIfNotExistYet();
    	subPages.add(subPage);
	}

	private void createSubmenuIfNotExistYet() {
		if (subPages == null) {
    		subPages = new ArrayList<CopyOfPage>();
    		addSubpages2Menu();
    	}
	}

	private void addSubpages2Menu() {
		Menu.getInstance().getMenu().put(url, subPages);
	}
}
