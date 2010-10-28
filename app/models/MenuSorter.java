package models;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

public class MenuSorter implements Comparator<Page> {

	@Override
	public int compare(Page page1, Page page2) {
		return getPosition(page1) - getPosition(page2);
	}

	private int getPosition(Page page2) {
		return 0;
	}
}

