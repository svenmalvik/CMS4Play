package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Content;
import models.Content2PageMapping;
import models.Menu;
import models.Page;
import static models.Menu.*;
import org.apache.commons.lang.StringUtils;

import play.mvc.Controller;

public class Application extends Controller {

    

	public static void index() {
		Content content = null;
		Page page = null;
		List<Page> submenu = null;
		
		// Mainmenu
		List<Page> mainmenu = Menu.getInstance().getSubmenuForUrl(URL_INDEX);
		
		// Submenu
		String url = params.get("url");
		if (StringUtils.isNotEmpty(url)) {
			submenu = Menu.getInstance().getSubmenuForUrl(url);
			//submenu = Menu.getInstance().
			page = Page.getPageFromUrl(url);
	    	
	    	
		} else {
			submenu = new ArrayList<Page>();
			page = Page.getPageFromUrl(URL_INDEX);
			
		}
		
		content = Content2PageMapping.getFirstC2PFromPage(page).content;
    	
		render(page, mainmenu, submenu, content);
    }
}