import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Content;
import models.Content2PageMapping;
import models.Menu;
import models.Page;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
 
@OnApplicationStart
public class Bootstrap extends Job {
 
    public void doJob() {
    	loadTestdata();
    }

	private void loadTestdata() {
		//Fixtures.load("data.yml");
		
		// Menu
		Map<String, List<Page>> menu = Menu.getInstance().getMenu();
    	
    	Content startseiteContent = new Content("Dies ist ein <b>Startseite</b>").save();
    	Content scrumContent = new Content("Dies ist Scrum").save();
    	Content scrumContent1 = new Content("Dies ist Scrum1").save();
    	Content scrumContent2 = new Content("Dies ist Scrum2").save();
    	Content leanContent = new Content("Dies Lean").save();
    	Content leanContent1 = new Content("Dies ist Lean1").save();
    	Content leanContent2 = new Content("Dies ist Lean2").save();    	
    	
    	Page startseitePage = new Page("Startseite", "index").save();
    	Page scrumPage = new Page("Scrum", "scrum").save();
    	Page scrumSub1Page = new Page("ScrumSub1", "scrumsub1").save();
    	Page scrumSub2Page = new Page("ScrumSub2", "scrumsub2").save();
    	Page leanPage = new Page("Lea", "lean").save();
    	Page leanSub1Page = new Page("LeanSub1", "leansub1").save();
    	Page leanSub2Page = new Page("LeanSub2", "leansub2").save();    	
    	
    	new Content2PageMapping(startseiteContent, startseitePage).save();
    	new Content2PageMapping(scrumContent, scrumPage).save();
    	new Content2PageMapping(scrumContent1, scrumSub1Page).save();
    	new Content2PageMapping(scrumContent2, scrumSub2Page).save();
    	new Content2PageMapping(leanContent, leanPage).save();
    	new Content2PageMapping(leanContent1, leanSub1Page).save();
    	new Content2PageMapping(leanContent2, leanSub2Page).save();    	
    	
    	List<Page> indexSubmenu = new ArrayList<Page>();
    	indexSubmenu.add(scrumPage);
    	indexSubmenu.add(leanPage);
    	menu.put(startseitePage.url, indexSubmenu);
    	
    	List<Page> leanSubmenu = new ArrayList<Page>();
    	leanSubmenu.add(leanSub1Page);
    	leanSubmenu.add(leanSub2Page);
    	menu.put(leanPage.url, leanSubmenu);
    	
    	List<Page> scrumSubmenu = new ArrayList<Page>();
    	scrumSubmenu.add(scrumSub1Page);
    	scrumSubmenu.add(scrumSub2Page);
    	menu.put(scrumPage.url, scrumSubmenu);
    	
    	// PagePathes
    	Map<String, List<Page>> pagePathes = Menu.getInstance().getPagePathes();
    	
    	List<Page> scrum1Path = new ArrayList<Page>();
    	scrum1Path.add(scrumPage);
    	pagePathes.put("scrumsub1", scrum1Path);
    	
    	List<Page> scrum2Path = new ArrayList<Page>();
    	scrum2Path.add(scrumPage);
    	pagePathes.put("scrumsub2", scrum2Path);
    	
    	List<Page> lean1Path = new ArrayList<Page>();
    	lean1Path.add(leanPage);
    	pagePathes.put("leansub1", lean1Path);
    	
    	List<Page> lean2Path = new ArrayList<Page>();
    	lean2Path.add(leanPage);
    	pagePathes.put("leansub2", lean2Path);    	
    		
    	   	
	}
}