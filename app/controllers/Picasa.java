package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import play.Play;

import models.ContentImage;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;

public class Picasa {

	private static String AUTHKEY;
	private static String USER;
	private static String ALBUM;
	private static String THUMBSIZES;
	private static boolean CONFIGS_READ = false;
	
	public static List<ContentImage> getImages(String tag) throws IOException, ServiceException {
        readConfigurations();
		URL metafeedUrl = new URL("https://picasaweb.google.com/data/feed/base/user/" + USER + "/album/" + ALBUM + "?imgmax=912&tag=" + tag + "&thumbsize=" + THUMBSIZES + "&authkey=" + AUTHKEY);
		PicasawebService myService = new PicasawebService("My Application");
        AlbumFeed resultFeed = myService.getFeed(metafeedUrl, AlbumFeed.class);
        return extractImageList(resultFeed.getPhotoEntries());
	}

	private static void readConfigurations() {
		if (!CONFIGS_READ) {
			Properties p = Play.configuration;
			USER = p.getProperty("picasa.user", "");
			ALBUM = p.getProperty("picasa.album", "");
			AUTHKEY = p.getProperty("picasa.authkey", "");
			THUMBSIZES = p.getProperty("picasa.thumbsizes", "");
		}
		CONFIGS_READ = true;
	}

	private static List<ContentImage> extractImageList(List<PhotoEntry> entries) {
		List<ContentImage> images = new ArrayList<ContentImage>();
		
        for(int i = 0; i < entries.size(); i++) {
          PhotoEntry photo = entries.get(i);
          ContentImage image = new ContentImage();
          image.src = photo.getMediaContents().get(0).getUrl();
          image.thumbnail1 = photo.getMediaThumbnails().get(0).getUrl();
          image.caption = photo.getTitle().getPlainText();
          images.add(image);
        }
		
		return images;
	}
}
