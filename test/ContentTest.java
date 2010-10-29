import static models.Menu.URL_INDEX;

import java.util.List;

import models.Menu;
import models.Page;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class ContentTest extends UnitTest {

    @Before
    public void setup() {
    	new TestData();
    }  
    
    @Test
    public void deletePage() {
    	Page page = Page.getPageFromUrl("kanban_measuring");
        assertNotNull(page);
        page.delete();
        
        Page pageDeleted = Page.getPageFromUrl("kanban_measuring");
        assertNull(pageDeleted);
    }
    
    @Test
    public void addPageToHome() {
    	Page subPage = new Page("New page", "new_page", URL_INDEX, 0);
    	Page.getPageFromUrl(URL_INDEX).addPage(subPage);
    	
		List<Page> submenu = Menu.getInstance().getSubmenuForUrl(URL_INDEX);
		assertEquals(7, submenu.size());
		subPage.delete();
    }
    
    @Test
    public void isScrumPageAtSecondPosition() {
    	Page scrum = Menu.getInstance().getSubmenuForUrl(URL_INDEX).get(1);
    	assertEquals("scrum", scrum.url);
    }
    
    @Test
    public void page() {
    	assertEquals(17, Page.findAll().size());
    	Page page = Page.getPageFromUrl(URL_INDEX);
        assertNotNull(page);
        assertEquals("Home", page.title);
    }

    @Test
    public void menu() {
		Page indexPage = Page.getPageFromUrl(URL_INDEX);
		List<Page> submenu = Menu.getInstance().getSubmenuForUrl(indexPage.url);
		assertEquals(6, submenu.size());
	}
    
    @Test
    public void editPageTitle() {
    	Page page = Page.getPageFromUrl(URL_INDEX);
    	page.title = "Home changed";
    	page.save();
    	Page pageChanged = Page.getPageFromUrl(URL_INDEX);
    	assertEquals(page.title, pageChanged.title);
    	page.title = "Home";
    	page.save();    	
	}
}
