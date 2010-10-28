import models.Menu;
import models.Page;


public class TestData {

	public TestData() {
    	Menu.reset();
    	loadTestdata();
	}
	
	private void loadTestdata() {
		Page pHome = new Page("Home", "index").save();
    	Page pCommandments = new Page("10 Commandments", "commandments").save();
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
    	Page pScrumSpike = new Page("Spike", "spike").save();
    	Page pCode = new Page("Code reviewing", "code").save();
    	Page pDod = new Page("Definition of Done", "dod").save();
    	
		pHome.addPage(pCommandments);
		pHome.addPage(pKanban);
		pHome.addPage(pScrum);
		pHome.addPage(pDod);
		pHome.addPage(pCode);
		pKanban.addPage(pKanbanVis, true);
		pKanban.addPage(pKanbanMeasure, true);
		pScrum.addPage(pScrumBacklog, true);
		pScrum.addPage(pScrumTaskboard, true);
		pScrum.addPage(pScrumTeamlookahead, true);
		pScrum.addPage(pScrumSprintplanning, true);
		pScrum.addPage(pScrumSprintdemo, true);
		pScrum.addPage(pScrumRetrospect, true);
		pScrum.addPage(pScrumDailystandup, true);
		pScrum.addPage(pScrumSprintburndownchart, true);
		pScrum.addPage(pScrumSpike, true);
	}
}
