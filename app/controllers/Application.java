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
		Content content = null;
		Page page = null;
		List<Page> submenu = null;
		String url = params.get("url");
		boolean cms = StringUtils.equals(params.get("cms"), "1") ? true : false;
		List<Page> pathToPage = Menu.getInstance().getPathToPageFromUrl(url);
		
		// Menu Level 0-n
		Map<String, List<Page>> menu = Menu.getInstance().getMenu();
		
		// Mainmenu Level0
		List<Page> mainmenu = Menu.getInstance().getSubmenuForUrl(URL_INDEX);
		
		// Submenu Level 1
		if (StringUtils.isNotEmpty(url) && !StringUtils.equals(URL_INDEX, url)) {
			if (pathToPage != null) {
				submenu = Menu.getInstance().getSubmenuForUrl(pathToPage.get(0).url);
				
			} else {
				submenu = Menu.getInstance().getSubmenuForUrl(url);
			}
			page = Page.getPageFromUrl(url);
	    	
	    	
		} else {
			submenu = new ArrayList<Page>();
			page = Page.getPageFromUrl(URL_INDEX);
			
		}
		content = Content.findById(Content2PageMapping.getFirstC2PFromPage(page).content.id);
		
		render(page, menu, mainmenu, submenu, pathToPage, content, cms);
    }
	
	public static void cms(Long contentId, String content) {
		Content _content = Content.findById(contentId);
		_content.content = content;
		_content.modifiedAt = new Date();
		_content.save();

		index();
	}
}