package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

	public static final String URL_INDEX = "index";
	private static Menu menu;
	private Map<String, List<Page>> _menu;

	public static Menu getInstance() {
		if (menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	private Menu() {
		if (isMenuNotBuildYet()) {
			_menu = new HashMap<String, List<Page>>();
			fillMenu();
		}
	}
	
	public Map<String, List<Page>> getMenu() {
		return _menu;
	}

	private void fillMenu() {
		// from db
	}

	private boolean isMenuNotBuildYet() {
		return _menu == null;
	}
	
	public List<Page> getSubmenuForUrl(String url) {
		return _menu.get(url);
	}
}
