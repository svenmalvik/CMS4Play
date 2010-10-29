package models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import play.Logger;

public class Menu {

	public static final String URL_INDEX = "index";
	private static Menu menu;
	private Map<String, List<Page>> _menu;
	private Map<String, List<Page>> pathToPage;

	public static Menu getInstance() {
		if (menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	private Menu() {
		if (isMenuNotBuildYet()) {
			_menu = new HashMap<String, List<Page>>();
			createPagePathes();
		}
	}
	
	public static void reset() {
		menu = null;
		getInstance();
	}
	
	private void createPagePathes() {
		pathToPage = new HashMap<String, List<Page>>();
	}
	
	public Map<String, List<Page>> getPagePathes() {
		return pathToPage;
	}

	public void createMenu() {
		List<Page> pages = Page.findAll();
		Iterator<Page> iter = pages.iterator();
		while (iter.hasNext()) {
			Page page = (Page) iter.next();
			Page.getPageFromUrl(page.parentPageUrl).addPage(page);
		}
	}

	private boolean isMenuNotBuildYet() {
		return _menu == null;
	}
	
	public List<Page> getSubmenuForUrl(String url) {
		List<Page> submenu = _menu.get(url);
		if (submenu != null) {
			Collections.sort(submenu, new MenuSorter());
		}
		return submenu;
	}

	public List<Page> getPathToPageFromUrl(String url) {
		return pathToPage.get(url);
	}

	public void addSubpages(String url, List<Page> subPages) {
		_menu.put(url, subPages);
	}

	public static void update() {
		Menu.reset();
		Menu.getInstance().createMenu();
	}
}
