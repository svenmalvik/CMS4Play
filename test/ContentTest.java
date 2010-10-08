import org.junit.*;
import java.util.*;

import play.db.jpa.JPA;
import play.test.*;
import models.*;

public class ContentTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteAll();
    }
    
    @Test
    public void createContent() {
    	new Content("My first content").save();
        
        List<Content> contents = Content.findAll();
        
        Content content = contents.get(0);
        assertEquals("My first content", content.content);
        assertNotNull(content.createdAt);
        assertNotNull(content.modifiedAt);
    }
}
