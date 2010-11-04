package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.google.gdata.util.ServiceException;

import controllers.Picasa;

import play.Logger;
import play.db.jpa.Model;

// @author Sven Malvik

@Entity
public class Content extends Model {

	@Lob
	public String content;
	public Date createdAt;
	public Date modifiedAt;
	@Transient
	public List<ContentImage> images;

	public Content(String content) {
		this.content = content;
		createdAt = new Date();
		modifiedAt = createdAt;
	}

	public Content() {
		new Content("");
	}

	public static void updateContent(Long contentId, String content) {
		Content _content = Content.findById(contentId);
		_content.content = content;
		_content.modifiedAt = new Date();
		_content.save();
	}

	public void updateImages() {
		try {
			images = Picasa.getImages("_" + id + "_");
		} catch (Exception e) {
			Logger.error(e, "Could not receive images for:%s", id);
		}
	}
}
