import org.junit.*;
import java.util.*;

import play.db.jpa.JPA;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteAll();
    }
    
    @Test
    public void createContent() {
    	new Content("My first content").save();
        
        assertEquals(1, Content.count());
        List<Content> contents = Content.findAll();
        
        // Tests
        assertEquals(1, contents.size());
        Content firstContent = contents.get(0);
        assertNotNull(firstContent);
        assertEquals("My first content", firstContent.content);
        assertNotNull(firstContent.createdAt);
    }
}
