package models;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

public class MenuSorter implements Comparator<Page> {

	@Override
	public int compare(Page page1, Page page2) {
		return page1.positionInMenu - page2.positionInMenu;
	}
}

