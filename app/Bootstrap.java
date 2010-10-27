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
    	new TestData();
    }


}