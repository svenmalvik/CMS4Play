import models.Menu;
import models.Page;


public class TestData {

	public TestData() {
    	Menu.reset();
    	loadTestdata();
	}
	
	private void loadTestdata() {
		new Page("Home", "index", "index", 0);
    	new Page("10 Commandments", "commandments", "index", 2);
    	new Page("Kanban", "kanban", "index", 3);
    	new Page("Visualizing", "kanban_visualizing", "kanban", 1);
    	new Page("Measuring", "kanban_measuring", "kanban", 0);
    	new Page("Scrum", "scrum", "index", 1);
    	new Page("Backlog", "scrum_backlog", "scrum", 0);
    	new Page("Task Board", "scrum_taskboard", "scrum", 1);
    	new Page("TeamLookAhead", "scrum_teanlookahaed", "scrum", 2);
    	new Page("Sprint Planning", "scrum_sprintplanning", "scrum", 3);
    	new Page("Sprint Demo", "scrum_sprintdemo", "scrum", 4);
    	new Page("Retrospect", "scrum_retrospect", "scrum", 5);
    	new Page("Daily Stand up", "scrum_dailystandup", "scrum", 6);
    	new Page("Sprint Burndown Chart", "scrum_sprintburndownchart", "scrum", 7);
    	new Page("Spike", "spike", "scrum", 8);
    	new Page("Code reviewing", "code", "index", 4);
    	new Page("Definition of Done", "dod", "index", 5);
    	
    	Menu.getInstance().createMenu();
	}
}
