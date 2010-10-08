package models;

//@author Sven Malvik

import play.db.jpa.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Content2PageMapping extends Model {
	
	long contentId;
	long pageId;
	
	public Content2PageMapping(long contentId, long pageId) {
		// @todo contentId and pageId must exist
		this.contentId = contentId;
		this.pageId = pageId;
	}
}