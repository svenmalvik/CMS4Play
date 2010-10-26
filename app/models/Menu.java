package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			createMenu();
			createPagePathes();
		}
	}
	
	private void createPagePathes() {
		pathToPage = new HashMap<String, List<Page>>();
	}
	
	public Map<String, List<Page>> getPagePathes() {
		return pathToPage;
	}

	public Map<String, List<Page>> getMenu() {
		return _menu;
	}

	private void createMenu() {
		_menu = new HashMap<String, List<Page>>();
	}

	private boolean isMenuNotBuildYet() {
		return _menu == null;
	}
	
	public List<Page> getSubmenuForUrl(String url) {
		return _menu.get(url);
	}

	public List<Page> getPathToPageFromUrl(String url) {
		return pathToPage.get(url);
	}
}
