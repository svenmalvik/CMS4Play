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
    	//Fixtures.load("data.yml");
    	
    	Map<String, List<Page>> menu = Menu.getInstance().getMenu();
    	
    	Content indexContent = new Content("Dies ist ein Indexseite").save();
    	Content startseiteContent = new Content("Dies ist ein Startseite").save();
    	Content scrumContent = new Content("Dies ist Scrum").save();
    	Content scrumContent1 = new Content("Dies ist Scrum1").save();
    	Content scrumContent2 = new Content("Dies ist Scrum2").save();
    	Content leanContent = new Content("Dies Lean").save();
    	
    	Page indexPage = new Page("Startseite", "index").save();
    	Page startseitePage = new Page("Startseite", "startseite").save();
    	Page scrumPage = new Page("Scrum", "scrum").save();
    	Page scrumSub1Page = new Page("ScrumSub1", "scrumsub1").save();
    	Page scrumSub2Page = new Page("ScrumSub2", "scrumsub2").save();
    	Page leanPage = new Page("Lea", "lean").save();
    	
    	new Content2PageMapping(indexContent, indexPage).save();
    	new Content2PageMapping(startseiteContent, startseitePage).save();
    	new Content2PageMapping(scrumContent, scrumPage).save();
    	new Content2PageMapping(scrumContent1, scrumSub1Page).save();
    	new Content2PageMapping(scrumContent2, scrumSub2Page).save();
    	new Content2PageMapping(leanContent, leanPage).save();
    	
    	List<Page> indexSubmenu = new ArrayList<Page>();
    	indexSubmenu.add(indexPage);
    	indexSubmenu.add(scrumPage);
    	indexSubmenu.add(leanPage);
    	menu.put(indexPage.url, indexSubmenu);
    	
    	List<Page> scrumSubmenu = new ArrayList<Page>();
    	scrumSubmenu.add(scrumSub1Page);
    	scrumSubmenu.add(scrumSub2Page);
    	menu.put(scrumPage.url, scrumSubmenu);
    }
}