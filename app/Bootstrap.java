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
    	Page pScrumBacklog = new Page("Backlog", "scrum_backlog").save();
    	Page pScrumTaskboard = new Page("Task Board", "scrum_taskboard").save();
    	Page pScrumTeamlookahead = new Page("TeamLookAhead", "scrum_teanlookahaed").save();
    	Page pScrumSprintplanning = new Page("Sprint Planning", "scrum_sprintplanning").save();
    	Page pScrumSprintdemo = new Page("Sprint Demo", "scrum_sprintdemo").save();
    	Page pScrumRetrospect = new Page("Retrospect", "scrum_retrospect").save();
    	Page pScrumDailystandup = new Page("Daily Stand up", "scrum_dailystandup").save();
    	Page pScrumSprintburndownchart = new Page("Sprint Burndown Chart", "scrum_sprintburndownchart").save();
    	Page pSpike = new Page("Spike", "spike").save();
    	Page pSpike_whatis = new Page("What is spike?", "spike_whatis").save();
    	Page pSpikeHowto = new Page("Use in CM & Wealth", "spike_howto").save();
    	Page pJira = new Page("Jira", "jira").save();
    	
    	List<Page> sub_pHome = new ArrayList<Page>();
    	sub_pHome.add(pBud);
    	sub_pHome.add(pKanban);
    	sub_pHome.add(pScrum);
    	sub_pHome.add(pSpike);
    	sub_pHome.add(pJira);
    	menu.put(pHome.url, sub_pHome);
    	
    	List<Page> sub_pKanban = new ArrayList<Page>();
    	sub_pKanban.add(pKanbanVis);
    	sub_pKanban.add(pKanbanMeasure);
    	menu.put(pKanban.url, sub_pKanban);
    	
    	List<Page> sub_pScrum = new ArrayList<Page>();
    	sub_pScrum.add(pScrumBacklog);
    	sub_pScrum.add(pScrumTaskboard);
    	sub_pScrum.add(pScrumTeamlookahead);
    	sub_pScrum.add(pScrumSprintplanning);
    	sub_pScrum.add(pScrumSprintdemo);
    	sub_pScrum.add(pScrumRetrospect);
    	sub_pScrum.add(pScrumDailystandup);
    	sub_pScrum.add(pScrumSprintburndownchart);
    	menu.put(pScrum.url, sub_pScrum);
    	
    	List<Page> sub_pSpike = new ArrayList<Page>();
    	sub_pSpike.add(pSpike_whatis);
    	sub_pSpike.add(pSpikeHowto);
    	menu.put(pSpike.url, sub_pSpike);
    	
    	// PagePathes
    	Map<String, List<Page>> pagePathes = Menu.getInstance().getPagePathes();
    	
    	List<Page> path_pKanbanVis = new ArrayList<Page>();
    	path_pKanbanVis.add(pKanban);
    	pagePathes.put(pKanbanVis.url, path_pKanbanVis);
    	
    	List<Page> path_pKanbanMeasure = new ArrayList<Page>();
    	path_pKanbanMeasure.add(pKanban);
    	pagePathes.put(pKanbanMeasure.url, path_pKanbanMeasure);    	
    	
    	List<Page> path_pScrumBacklog = new ArrayList<Page>();
    	path_pScrumBacklog.add(pScrum);
    	pagePathes.put(pScrumBacklog.url, path_pScrumBacklog);    	
    	
    	List<Page> path_pScrumTaskboard = new ArrayList<Page>();
    	path_pScrumTaskboard.add(pScrum);
    	pagePathes.put(pScrumTaskboard.url, path_pScrumTaskboard);    	
    	
    	List<Page> path_pScrumTeamlookahead = new ArrayList<Page>();
    	path_pScrumTeamlookahead.add(pScrum);
    	pagePathes.put(pScrumTeamlookahead.url, path_pScrumTeamlookahead);    	
    	
    	List<Page> path_pScrumSprintplanning = new ArrayList<Page>();
    	path_pScrumSprintplanning.add(pScrum);
    	pagePathes.put(pScrumSprintplanning.url, path_pScrumSprintplanning);    	
    	
    	List<Page> path_pScrumSprintdemo = new ArrayList<Page>();
    	path_pScrumSprintdemo.add(pScrum);
    	pagePathes.put(pScrumSprintdemo.url, path_pScrumSprintdemo);    	
    	
    	List<Page> path_pScrumRetrospect = new ArrayList<Page>();
    	path_pScrumRetrospect.add(pScrum);
    	pagePathes.put(pScrumRetrospect.url, path_pScrumRetrospect);    	
    	
    	List<Page> path_pScrumDailystandup = new ArrayList<Page>();
    	path_pScrumDailystandup.add(pScrum);
    	pagePathes.put(pScrumDailystandup.url, path_pScrumDailystandup);  
    	
    	List<Page> path_pScrumSprintburndownchart = new ArrayList<Page>();
    	path_pScrumSprintburndownchart.add(pScrum);
    	pagePathes.put(pScrumSprintburndownchart.url, path_pScrumSprintburndownchart);  
    	
    	List<Page> path_pSpike_whatis = new ArrayList<Page>();
    	path_pSpike_whatis.add(pSpike);
    	pagePathes.put(pSpike_whatis.url, path_pSpike_whatis);  
    	
    	List<Page> path_pSpikeHowto = new ArrayList<Page>();
    	path_pSpikeHowto.add(pSpike);
    	pagePathes.put(pSpikeHowto.url, path_pSpikeHowto);  
    	
	
	}
}