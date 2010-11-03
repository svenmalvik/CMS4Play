package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.List;

import models.ContentImage;

import com.google.gdata.client.Query;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.UserFeed;
import com.google.gdata.util.ServiceException;

public class Picasa {

	public static List<ContentImage> getImages(String tag) throws IOException, ServiceException {
		URL metafeedUrl = new URL("https://picasaweb.google.com/data/feed/base/user/svenmalvik/album/cm?imgmax=912&tag=" + tag + "&thumbsize=32&authkey=Gv1sRgCOu93ZCOr6vNWg");

		PicasawebService myService = new PicasawebService("My Application");

        System.out.println("Getting Picasa Web Albums entries...");
        UserFeed resultFeed = myService.getFeed(metafeedUrl, UserFeed.class);
        List<GphotoEntry> entries = resultFeed.getEntries();
        for(int i=0; i<entries.size(); i++) {
          GphotoEntry entry = entries.get(i);
          System.out.println("\t" + entry.getTitle().getPlainText());
        }
        System.out.println("Total Entries: "+entries.size());
		
		return null;
	}

}
