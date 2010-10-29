package controllers;

import static models.Menu.URL_INDEX;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import models.Content;
import models.Content2PageMapping;
import models.Menu;
import models.Page;

import org.apache.commons.lang.StringUtils;

import play.Logger;
import play.mvc.Controller;

public class Application extends Controller {

	private static final String EXT_HTML = ".html";

	public static void index() {
		String url = getUrl();
		List<Page> pathToPage = Menu.getInstance().getPathToPageFromUrl(url);
		List<Page> submenu = isNotIndexPage(url) ? getSubmenu(pathToPage) : new ArrayList<Page>();
		String pageUrl = isNotIndexPage(url) ? url : URL_INDEX;
		Page page = Page.getPageFromUrl(pageUrl);
		Content content = getContent(page);
		List<Page> mainmenu = Menu.getInstance().getSubmenuForUrl(URL_INDEX);
		boolean cms = flash.contains("cms");
		String edit = flash.get("edit");
		render(page, mainmenu, submenu, pathToPage, content, cms, url, edit);
	}

	private static List<Page> getSubmenu(List<Page> pathToPage) {
		String subMenuUrl = (pathToPage != null) ? pathToPage.get(0).url : getUrl();
		return Menu.getInstance().getSubmenuForUrl(subMenuUrl);
	}

	private static boolean isNotIndexPage(String url) {
		return StringUtils.isNotEmpty(url)
				&& !StringUtils.equals(URL_INDEX, url);
	}

	private static String getUrl() {
		String url = params.get("url");
		if (flash.contains("url")) {
			url = flash.get("url");
		}
		if (StringUtils.isEmpty(url)) {
			url = URL_INDEX;
		}
		return url;
	}

	private static Content getContent(Page page) {
		Content2PageMapping c2p = Content2PageMapping.getFirstC2PFromPage(page);
		if (c2p == null) {
			Content content = new Content("").save();
			c2p = new Content2PageMapping(content, page).save();
		}
		return Content.findById(c2p.content.id);
	}

	public static void cms() {
		String editType = params.get("edit");
		
		if (StringUtils.isNotEmpty(editType)) {
			flash("cms", "1");
			flash("edit", editType);
			if (params.get("url") != null) flash("url", params.get("url"));
		}
		redirect("Application.index");
	}
	
	public static void savePage(String alias, String title, String url) {
		Page page = Page.getPageFromUrl(url);
		page.title = title;
		//page.url = alias;
		page.save();
		Menu.update();
		redirect("/" + url + EXT_HTML);
	}	

	public static void saveContent(Long contentId, String content, String url) {
		Content.updateContent(contentId, content);
		redirect("/" + url + EXT_HTML);
	}
}