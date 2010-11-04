package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import models.ContentImage;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.util.ServiceException;

public class Picasa {

	public static List<ContentImage> getImages(String tag) throws IOException, ServiceException {
		List<ContentImage> images = new ArrayList<ContentImage>();
		URL metafeedUrl = new URL("https://picasaweb.google.com/data/feed/base/user/svenmalvik/album/cm?imgmax=912&tag=" + tag + "&thumbsize=32&authkey=Gv1sRgCOu93ZCOr6vNWg");
		PicasawebService myService = new PicasawebService("My Application");
        AlbumFeed resultFeed = myService.getFeed(metafeedUrl, AlbumFeed.class);
        List<GphotoEntry> entries = resultFeed.getEntries();
        
        for(int i=0; i<entries.size(); i++) {
          GphotoEntry entry = entries.get(i);
          ContentImage image = new ContentImage();
          image.src = entry.getSelfLink().getHref();
          images.add(image);
        }
		
		return images;
	}

}
