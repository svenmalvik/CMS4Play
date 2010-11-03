package models;

import java.util.Comparator;

public class MenuSorter implements Comparator<Page> {

	@Override
	public int compare(Page page1, Page page2) {
		return page1.positionInMenu - page2.positionInMenu;
	}
}

