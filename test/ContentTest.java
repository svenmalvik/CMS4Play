import static models.Menu.URL_INDEX;

import java.io.IOException;
import java.util.List;

import models.ContentImage;
import models.Menu;
import models.Page;

import org.junit.Before;
import org.junit.Test;

import com.google.gdata.util.ServiceException;

import play.test.UnitTest;
import controllers.Picasa;

public class ContentTest extends UnitTest {

    @Before
    public void setup() {
    	new TestData();
    }  
    
    @Test
    public void getImagesForContent() {
    	List<ContentImage> images = null;
		try {
			images = Picasa.getImages("_1_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(2, images.size());
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
    public void allPossibleParentPages() {
    	List<Page> parentPages = Page.getAllPossibleParentPages();
    	assertEquals(6, parentPages.size());
    	assertEquals("commandments", parentPages.get(0).url);
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
