import java.util.List;

import models.Content;
import models.Content2PageMapping;
import models.Menu;
import models.Page;
import static models.Menu.*;

import org.junit.BeforeClass;
import org.junit.Test;

import play.test.UnitTest;

public class ContentTest extends UnitTest {

    @BeforeClass
    public static void setup() {
        //Fixtures.deleteAll();
        //Fixtures.load("data.yml");
    }  
    
    @Test
    public void content() {
        List<Content> contents = Content.findAll();
        Content content = contents.get(0);
        assertEquals("Dies ist ein Startseite", content.content);
    }
    
    @Test
    public void page() {
    	assertEquals(Page.findAll().size(), 4);
    	Page page2 = Page.getPageFromUrl(URL_INDEX);
        assertNotNull(page2);
    }
    
    @Test
    public void c2p() {
    	Page page = Page.getPageFromUrl("startseite");
    	assertEquals(Content2PageMapping.findAll().size(), 3);
    	Content2PageMapping c2p = Content2PageMapping.getFirstC2PFromPage(page);
    	assertNotNull(c2p);
    	assertNotNull(c2p.content);
    }

    public void menu() {
		Page indexPage = Page.getPageFromUrl(URL_INDEX);
		List<Page> submenu = Menu.getInstance().getSubmenuForUrl(indexPage.url);
		assertEquals(2, submenu.size());
	}
}
