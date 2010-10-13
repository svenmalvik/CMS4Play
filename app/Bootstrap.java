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
    	
    	Page pHome = new Page("Home", "index").save();
    	Page pBud = new Page("10 Bud", "bud").save();
    	Page pKanban = new Page("Kanban", "kanban").save();
    	Page pKanbanVis = new Page("Visualizing", "kanban_visualizing").save();
    	Page pKanbanMeasure = new Page("Measuring", "kanban_measuring").save();
    	Page pScrum = new Page("Scrum", "scrum").save();
//    	Page pScrumBacklog = new Page("Backlog", "scrum_backlog").save();
//    	Page pScrumTaskboard = new Page("Task Board", "scrum_taskboard").save();
//    	Page pScrumTeamlookahead = new Page("TeamLookAhead", "scrum_teanlookahaed").save();
//    	Page pScrumSprintplanning = new Page("Sprint Planning", "scrum_sprintplanning").save();
//    	Page pScrumSprintdemo = new Page("Sprint Demo", "scrum_sprintdemo").save();
//    	Page pScrumRetrospect = new Page("Retrospect", "scrum_retrospect").save();
//    	Page pScrumDailystandup = new Page("Daily Stand up", "scrum_dailystandup").save();
//    	Page pScrumSprintburndownchart = new Page("Sprint Burndown Chart", "scrum_sprintburndownchart").save();
    	Page pSpike = new Page("Spike", "spike").save();
//    	Page pSpike_whatis = new Page("What is spike?", "spike_whatis").save();
//    	Page pSpikeHowto = new Page("Use in CM & Wealth", "spike_howto").save();
    	
    	List<Page> sub_pHome = new ArrayList<Page>();
    	sub_pHome.add(pBud);
    	sub_pHome.add(pKanban);
    	sub_pHome.add(pScrum);
    	sub_pHome.add(pSpike);
    	menu.put(pHome.url, sub_pHome);
    	
    	List<Page> sub_pKanban = new ArrayList<Page>();
    	sub_pKanban.add(pKanbanVis);
    	sub_pKanban.add(pKanbanMeasure);
    	menu.put(pKanban.url, sub_pKanban);
    	
    	// PagePathes
    	Map<String, List<Page>> pagePathes = Menu.getInstance().getPagePathes();
    	
    	List<Page> path_pKanbanVis = new ArrayList<Page>();
    	path_pKanbanVis.add(pKanban);
    	pagePathes.put(pKanbanVis.url, path_pKanbanVis);
    	
    	List<Page> path_pKanbanMeasure = new ArrayList<Page>();
    	path_pKanbanMeasure.add(pKanban);
    	pagePathes.put(pKanbanMeasure.url, path_pKanbanMeasure);    	
    	
//    	Page scrumPage = new Page("Scrum", "scrum").save();
//    	Page scrumSub1Page = new Page("ScrumSub1", "scrumsub1").save();
//    	Page scrumSub2Page = new Page("ScrumSub2", "scrumsub2").save();
//    	Page leanPage = new Page("Lea", "lean").save();
//    	Page leanSub1Page = new Page("LeanSub1", "leansub1").save();
//    	Page leanSub2Page = new Page("LeanSub2", "leansub2").save();  
//		
//		Content startseiteContent = new Content("Dies ist ein <b>Startseite</b>").save();
//    	Content scrumContent = new Content("Dies ist Scrum").save();
//    	Content scrumContent1 = new Content("Dies ist Scrum1").save();
//    	Content scrumContent2 = new Content("Dies ist Scrum2").save();
//    	Content leanContent = new Content("Dies Lean").save();
//    	Content leanContent1 = new Content("Dies ist Lean1").save();
//    	Content leanContent2 = new Content("Dies ist Lean2").save();
//    	
//    	new Content2PageMapping(startseiteContent, pHome).save();
//    	new Content2PageMapping(scrumContent, scrumPage).save();
//    	new Content2PageMapping(scrumContent1, scrumSub1Page).save();
//    	new Content2PageMapping(scrumContent2, scrumSub2Page).save();
//    	new Content2PageMapping(leanContent, leanPage).save();
//    	new Content2PageMapping(leanContent1, leanSub1Page).save();
//    	new Content2PageMapping(leanContent2, leanSub2Page).save();    	
//        	
//    	List<Page> scrumSubmenu = new ArrayList<Page>();
//    	scrumSubmenu.add(scrumSub1Page);
//    	scrumSubmenu.add(scrumSub2Page);
//    	menu.put(scrumPage.url, scrumSubmenu);
//    	
//    	// PagePathes
//    	Map<String, List<Page>> pagePathes = Menu.getInstance().getPagePathes();
//    	
//    	List<Page> scrum1Path = new ArrayList<Page>();
//    	scrum1Path.add(scrumPage);
//    	pagePathes.put("scrumsub1", scrum1Path);
//    	
//    	List<Page> scrum2Path = new ArrayList<Page>();
//    	scrum2Path.add(scrumPage);
//    	pagePathes.put("scrumsub2", scrum2Path);
//    	
//    	List<Page> lean1Path = new ArrayList<Page>();
//    	lean1Path.add(leanPage);
//    	pagePathes.put("leansub1", lean1Path);
//    	
//    	List<Page> lean2Path = new ArrayList<Page>();
//    	lean2Path.add(leanPage);
//    	pagePathes.put("leansub2", lean2Path);    	
    		
    	   	
	}
}