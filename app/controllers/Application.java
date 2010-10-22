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

import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		String url = params.get("url");
		if (flash.contains("url")) {
			url = flash.get("url");
		}

		System.out.println(url);
		List<Page> pathToPage = Menu.getInstance().getPathToPageFromUrl(url);
		
		// Submenu Level 1
		List<Page> submenu = null;
		String pageUrl = "";
		if (StringUtils.isNotEmpty(url) && !StringUtils.equals(URL_INDEX, url)) {
			if (pathToPage != null) {
				submenu = Menu.getInstance().getSubmenuForUrl(pathToPage.get(0).url);
				
			} else {
				submenu = Menu.getInstance().getSubmenuForUrl(url);
			}
			pageUrl = url;
	    	
		} else {
			submenu = new ArrayList<Page>();
			pageUrl = URL_INDEX;
		}
		Page page = Page.getPageFromUrl(pageUrl);
		Map<String, List<Page>> menu = Menu.getInstance().getMenu();
		Content content = getContent(page);
		List<Page> mainmenu = Menu.getInstance().getSubmenuForUrl(URL_INDEX);
		boolean cms = flash.contains("cms");
		render(page, menu, mainmenu, submenu, pathToPage, content, cms);
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
		flash("cms", "1");
		if (params.get("url") != null) flash("url", params.get("url"));
		redirect("Application.index");
	}
	
	public static void save(Long contentId, String content) {
		Content _content = Content.findById(contentId);
		_content.content = content;
		_content.modifiedAt = new Date();
		_content.save();

		index();
	}
}